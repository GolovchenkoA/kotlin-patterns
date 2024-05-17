package org.example.chainofresponsibility.example3

import org.example.chainofresponsibility.example3.handler.HandlerLink
import org.example.chainofresponsibility.example3.handler.LinkableHandler

/**
 * A place where multiple handling statements can be added.
 *
 * @param linkableHandlerCreator A class that creates new [LinkableHandler]s.
 */
//@ChainOfResponsibilityDsl
class HandleableContextImpl<T>(private val linkableHandlerCreator: () -> LinkableHandler<T>)  : HandleableContext<T> {
    override val links: MutableList<LinkableHandler<T>> = mutableListOf()
//        get() = TODO("Not yet implemented")

//    override fun handle(handlerLinkConsumer: LinkableHandler<T>.() -> Unit) {
//        val handlerLink = HandlerLink<T>()
//        handlerLinkConsumer.invoke(handlerLink)
//        this.links.add(handlerLink)
//    }

    /**
     * Allows defining how to handle using `by` and `whenever`.
     *
     * @param handlerLinkConsumer A consumer of a handler link.
     */
    override fun handle(handlerLinkConsumer: LinkableHandler<T>.() -> Unit) {
        with(linkableHandlerCreator.invoke()) {
            handlerLinkConsumer.invoke(this)
            links.add(this)
        }
    }
}