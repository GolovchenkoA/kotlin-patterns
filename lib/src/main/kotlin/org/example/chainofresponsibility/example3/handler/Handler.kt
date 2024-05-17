package org.example.chainofresponsibility.example3.handler

interface Handler<T> {
    /**
     * Processes the data.
     *
     * @param event The data.
     */
    fun process(event: T)
}