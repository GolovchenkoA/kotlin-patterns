package org.example

object Logger {

    init {
        println("I was accessed for the first time")

        // Initialization logic goes here
    }

    var name: String? = null

    fun log(msg: String) {
        println("[$name] $msg")
    }
}