package org.example.chainofresponsibility.example0wrongorder

import org.example.chainofresponsibility.example2.Request
import org.example.chainofresponsibility.example2.Response

fun main() {
    fun doAndPrintResult(f: (Int, Int) -> Int) {
        val result = f(1, 2)
        println("doAndPrintResult $result")
    }
    fun doAndPrintResult2(f: IntOp) {
        val result = f(1, 2)
        println("doAndPrintResult $result")
    }

    fun add(f:(Int,Int) -> Int, msg: String) = fun(a: Int, b: Int): (Int, Int) -> Int {
        val function: (Int, Int) -> Int = { a, b -> a + b }
        println("$msg : $a + $b")
        return function
    }

    fun multiply(f:(Int,Int) -> Int, msg: String) = fun(a: Int, b: Int): (Int, Int) -> Int {
        val function: (Int, Int) -> Int = { a, b -> a * b }
        println("$msg : $a * $b")
        return function
    }

//    doAndPrintResult { x, y -> x + y + 1000 }
//    doAndPrintResult { x, y -> y - x }

//    val muli = multiply({a,b -> a}, "multiply")
//    add(muli,"add function")(1,1)


    //////////////////////////////////
//    fun modifyInt(initValue: Int, f:(Int) -> Int): Int {
//        return f(initValue)
//    }
//    fun modifyInt2(initValue: Int, f:(Int) -> Int): Int {
//        return f(initValue)
//    }
//    fun modifyInt3(initValue: Int, f:(Int) -> Int): Int {
//        return f(initValue)
//    }
//
//    modifyInt3(2) { n ->
//        n + 2
//    }

    ///////////////////////

    val apply0 = fun(next: (Request) -> Response): (Request) -> Response {
        println("execute apply0")
        return {r -> next(r)}
    }

    val apply1 = fun(next: RequestToResponseOp): RequestToResponseOp {
        println("execute apply1")
        return {r -> next(r)}
    }

    val apply2 = fun(next: (Request) -> Response) = fun(request: Request): Response {
        println("execute apply2")
        return next(request)
    }

    val apply4 = fun(next: RequestToResponseOp) = fun(request: Request): Response {
        println("execute apply4")
        return next(request)
    }

    val funReturnsResponseV1:(Request) -> Response = fun(req: Request): Response {
        println("execute funReturnsResponse v1")
        return Response("${req.email} ${req.question}")
    }

    val funReturnsResponseV2 = fun(req: (Request)): Response {
        println("execute funReturnsResponse v2")
        return Response("${req.email} ${req.question}")
    }

    val chain1 = apply0(apply1(apply2(apply3(apply4(funReturnsResponseV1)))))

    val response1 = chain1(Request("email", "question"))
    println("Response $response1")
// output:
//execute apply3
//execute apply1
//execute apply0
//execute apply2
//execute apply4
//execute funReturnsResponse v1

//    println()
//    val chain2 = apply0(apply1(apply2(apply3(apply4(funReturnsResponseV2)))))
//    val response2 = chain2(Request("email", "question"))
//    println("Response $response2")


}

fun apply3(next: (Request) -> Response):(Request) -> Response {
    println("execute apply3")
   return  {r -> next(r)}
}

typealias IntOp = (Int, Int) -> Int
typealias RequestToResponseOp = (Request) -> Response