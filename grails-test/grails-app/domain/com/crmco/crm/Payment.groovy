package com.crmco.crm

class Payment {

	BigDecimal amount
	PaymentStatus status
	static hasMany = [transactions: Transaction]
	Applicant applicant
	
    static constraints = {
    }
}
