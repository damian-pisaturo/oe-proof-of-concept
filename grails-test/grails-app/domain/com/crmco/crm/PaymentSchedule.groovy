package com.crmco.crm

class PaymentSchedule extends Applicant {

	Date creationDate
	Integer paymentDay
	BigDecimal initialAmount
	Integer installments
	Integer paidInstallments
	Integer failedInstallments
	PaymentSchedule child
	static hasMany = [skippedPayments: SkippedPayment]
	
    static constraints = {
    }
}
