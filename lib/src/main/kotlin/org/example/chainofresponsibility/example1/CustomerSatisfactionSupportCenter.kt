package org.example.chainofresponsibility.example1

class CustomerSatisfactionSupportCenter(requestType: RequestType) : AbstractSupportCenterHandler(requestType) {
    override var nextHandler: AbstractSupportCenterHandler? = null
    override fun handleRequest(message: String): String {
        return "Handler: CustomerSatisfactionSupportHandler - request: $message"
    }
}