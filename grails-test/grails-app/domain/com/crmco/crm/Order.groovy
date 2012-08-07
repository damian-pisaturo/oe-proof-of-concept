package com.crmco.crm

class Order {

	Date creationDate
	BigDecimal totalAmount
	Integer courses
	static belongsTo = [owner: Client]
	PaymentSchedule paymentSchedule
	static hasMany = [paymentsOnDemand: PaymentOnDemand, refunds: Refund, payments: Payment]
	
	static mapping = {
		table 'purchase_order'
	}
	
    static constraints = {
    }
}
