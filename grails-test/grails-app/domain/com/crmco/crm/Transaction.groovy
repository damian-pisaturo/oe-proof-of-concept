package com.crmco.crm

class Transaction {

	Date createdAt
	Date processedAt
	TransactionType type
	TransactionStatus status
	Currency currency
	User author
	Gateway gateway
	static belongsTo = [payment: Payment, batch: Batch]
	
    static constraints = {
    }
}
