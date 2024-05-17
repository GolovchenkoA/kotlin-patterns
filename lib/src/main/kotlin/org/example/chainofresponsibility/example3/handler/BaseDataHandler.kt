package org.example.chainofresponsibility.example3.handler

import org.example.chainofresponsibility.example3.Event

abstract class BaseDataHandler(val next: Handler<Event>?) : Handler<Event> {

    /**
     * Pass the data to the next handler in the chain.
     *
     * @param event The data.
     */
    fun passToNext(event: Event) {
        next?.process(event) ?: throw IllegalArgumentException("Couldn't handle $event!")
    }
}