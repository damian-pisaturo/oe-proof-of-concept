package com.crmco.crm

class Batch {

	Date runDate
	BatchType type
	BatchStatus status
	User author
	static hasMany = [transactions: Transaction]
	
    static constraints = {
    }
}
