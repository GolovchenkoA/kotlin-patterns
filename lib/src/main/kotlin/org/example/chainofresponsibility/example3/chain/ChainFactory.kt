package org.example.chainofresponsibility.example3.chain

import org.example.chainofresponsibility.example3.HandleableContext
import org.example.chainofresponsibility.example3.HandleableContextImpl
import org.example.chainofresponsibility.example3.handler.HandlerLink

interface ChainFactory {
    /**
     * Builds a chain to handle T.
     *
     * @param T the data the chain will handle.
     * @param handleableContextCreator A creator of [HandleableContext]s, which supplies a new one each time.
     * @param handleableContextConsumer A consumer that passes a context to call [HandleableContextImpl.handle] on.
     */
    fun <T> chainOf(handleableContextCreator: () -> HandleableContext<T> = {
            HandleableContextImpl { HandlerLink() }
                                                               },
        handleableContextConsumer: HandleableContext<T>.() -> Unit
    ): Chain<T>
}