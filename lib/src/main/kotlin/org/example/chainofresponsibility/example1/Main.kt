package org.example.chainofresponsibility.example1

// source: https://www.baeldung.com/kotlin/chain-of-responsibility-pattern
object SupportCenterClient {
    val technicalHandler =
        TechnicalSupportCenter(AbstractSupportCenterHandler.RequestType.TECHNICAL)
}

fun main() {
    val response1 = SupportCenterClient.technicalHandler.receiveRequest(AbstractSupportCenterHandler.RequestType.BILL, "ABC message")
    println(response1)

    val response2 = SupportCenterClient.technicalHandler.receiveRequest(AbstractSupportCenterHandler.RequestType.UNKNOWN, "ABC message")
    println(response2)
}