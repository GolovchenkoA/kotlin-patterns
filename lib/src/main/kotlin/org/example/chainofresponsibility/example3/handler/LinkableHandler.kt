package org.example.chainofresponsibility.example3.handler

interface LinkableHandler<T> {

    val predicateSupplier: (T.() -> Boolean)

    val handlerSupplier: () -> Handler<T>

    fun by(handlerSupplier: () -> Handler<T>)

    fun whenever(predicateSupplier: T.() -> Boolean)
}