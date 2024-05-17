package org.example

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LoggerTest {

    @Test
    fun log() {

        Logger.log("msg1")

        Logger.name = "name 2"
        Logger.log("msg2")
        Logger.log("msg3")

        Logger.name = "name 4"
        Logger.log("msg4")
    }
}