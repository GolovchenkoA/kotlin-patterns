package org.example.chainofresponsibility.example1

class BillsSupportCenter(requestType: RequestType) : AbstractSupportCenterHandler(requestType){
    override var nextHandler: AbstractSupportCenterHandler? = CustomerSatisfactionSupportCenter(RequestType.CUSTOMER_SATISFACTION)
    override fun handleRequest(message: String): String {
        return "Handler: BillsSupportHandler - request: $message"
    }
}