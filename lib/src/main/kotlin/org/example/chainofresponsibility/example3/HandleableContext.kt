package org.example.chainofresponsibility.example3

import org.example.chainofresponsibility.example3.handler.LinkableHandler

interface HandleableContext<T> {

    val links: MutableList<LinkableHandler<T>>

    fun handle(handlerLinkConsumer: LinkableHandler<T>.() -> Unit)
}