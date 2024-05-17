package org.example.chainofresponsibility.example3

import org.example.chainofresponsibility.example3.handler.BaseDataHandler
import org.example.chainofresponsibility.example3.handler.Handler

class ScenarioOneHandler(next: Handler<Event>? = null) : BaseDataHandler(next) {

    override fun process(event: Event) {
        // Inspect the data looking for a handling trait.
        if (event.name.length < 7) {
            println("ScenarioOneHandler handling $event")
        } else {
            // Can't handle this data, calling the next link in the chain.
            passToNext(event)
        }
    }
}