package org.example.chainofresponsibility.example1

class TechnicalSupportCenter(requestType: RequestType) : AbstractSupportCenterHandler(requestType) {
    override var nextHandler: AbstractSupportCenterHandler? = BillsSupportCenter(RequestType.BILL)
    override fun handleRequest(message: String): String {
        return "Handler: TechnicalSupportHandler - request: $message"
    }
}