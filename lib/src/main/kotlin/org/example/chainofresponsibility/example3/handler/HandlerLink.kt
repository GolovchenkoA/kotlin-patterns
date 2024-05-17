package org.example.chainofresponsibility.example3.handler

class HandlerLink<T> : LinkableHandler<T> {
    override lateinit var predicateSupplier: T.() -> Boolean

    override lateinit var  handlerSupplier: () -> Handler<T>
//        get() = TODO("Not yet implemented")

    override fun by(handlerSupplier: () -> Handler<T>) {
        this.handlerSupplier = handlerSupplier
    }

    override fun whenever(predicateSupplier: T.() -> Boolean) {
        this.predicateSupplier = predicateSupplier
    }
}