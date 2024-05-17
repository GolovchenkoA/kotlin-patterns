package org.example.chainofresponsibility.example3.chain

import org.example.chainofresponsibility.example3.HandleableContext
import org.example.chainofresponsibility.example3.handler.LinkableHandler

class Chain<T> private constructor(val links: List<LinkableHandler<T>>) {

    fun process(data: T) {
        links.firstOrNull { it.predicateSupplier(data) }
            ?.handlerSupplier
            ?.invoke()
            ?.process(data)
            ?: throw IllegalArgumentException("No handler set up to handle: $data")
    }

    companion object : ChainFactory {

        /**
         * Builds a chain to handle T.
         *
         * @param T the data type the chain will handle.
         * @param handleableContextCreator A creator of [HandleableContext]s, which supplies a new one each time.
         * @param handleableContextConsumer A consumer that passes a context to call [HandleableContextImpl.handle] on.
         */
        override fun <T> chainOf(
            handleableContextCreator: () -> HandleableContext<T>,
            handleableContextConsumer: HandleableContext<T>.() -> Unit
        ): Chain<T> {
            // Build a handleable context and pass it to the DSL calling code.
            with(handleableContextCreator.invoke()) {
                handleableContextConsumer.invoke(this)
                // Return a chain formed by the context links.
                return Chain(links)
            }
        }
    }
}