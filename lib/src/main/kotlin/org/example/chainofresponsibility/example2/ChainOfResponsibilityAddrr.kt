package org.example.chainofresponsibility.example2//package org.example
//
//
//
//fun main() {
//    val holder = Holder(10)
//
//    val calculation: (Holder) -> Result = resultWrapper(adder(substracter()))
//
//    println(calculation(holder))
//}
//
//fun resultWrapper(holder: Holder): (Holder) -> Result {
//    return (holder) -> Result("Result is: ${holder.value}")
//}
//
//fun adder(holder: Holder): Holder {
//    return Holder(holder.value - 10)
//}
//
//fun substracter(holder: Holder): Holder {
//    return Holder(holder.value - 1)
//}
////
////fun main() {
////    val req = Holder(10)
////
////    val chain = basicValidation3(authentication3(finalResponse3()))
////
////    val res = chain(req)
////
////    println(res)
////}
//////
//////fun handler3(): (request: Request) -> Response {
//////    TODO("Not yet implemented")
//////}
//////
//////fun handler2(next: Handler): Handler {
//////    TODO("Not yet implemented")
//////}
//////
//////fun handler1(next: Handler): Response {
//////    val request: Request = TODO()
//////    return next(request)
//////}
////
//
////
////// This is the incorrect implementation of what we want to achieve
////fun handleRequest3(r: Request) {
////    // Validate
////    if (r.email.isEmpty() || r.question.isEmpty()) {
////        return
////    }
////
////    // Authenticate
////    // Make sure that you know whos is this user
////    if (r.isKnownEmail()) {
////        return
////    }
////
////    // Authorize
////    // Requests from juniors are automatically ignored by architects
////    if (r.isFromJuniorDeveloper()) {
////        return
////    }
////
////    println("I don't know. Did you check StackOverflow?")
////}
////
////val authentication3 = fun(next: Handler) = fun(request: Request): Response {
////        require(request.isKnownEmail()) { "Unknown email address" }
////        return next(request)
////    }
////
//////val basicValidation: (Handler) -> (Request) -> Response = fun(next: Handler) = fun(request: Request): Response {
////val basicValidation3 = fun(next: Handler) = fun(request: Int): Int {
////        if (request.va.isEmpty() || request.question.isEmpty()) {
////            throw IllegalArgumentException()
////        }
////        return next(request)
////    }
////
//////fun basicValidation2(next: Handler) = {
////////        if (request.email.isEmpty() || request.question.isEmpty()) {
////////            throw IllegalArgumentException()
////////        }
////////        return next(request)
//////    return Handler(r: Request) {
//////        return Response("abc")
//////    }
//////    }
////
////// Original
////val finalResponse3 = fun() = fun(request: Holder): Response {
////        return Response("Result is: ")
////    }
////
//data class Result(val answer: String)
//data class Holder(val value: Int)
//typealias HandlerHolder = (request: Holder) -> Holder