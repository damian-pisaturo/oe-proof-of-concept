package com.crmco.crm

class PaymentProfile {

	String address
	String zipCode
	String phoneNumber
	boolean recurrentPayment
	Integer payDay
	Integer monthlyFrecuence
	Integer maxBillings
	City city
	static hasMany = [paymentMethods: PaymentMethod]
	
    static constraints = {
    }
}
