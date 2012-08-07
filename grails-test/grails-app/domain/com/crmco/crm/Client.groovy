package com.crmco.crm

class Client {

	String idd
	String email
	Date createdAt
	Date updatedAt
	boolean enabled
	City city
	EmploymentData employmentData
	Account account
	PaymentProfile paymentProfile
	static hasMany = [orders: Order]
	
    static constraints = {
    }
}
