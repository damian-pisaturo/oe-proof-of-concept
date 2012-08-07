package com.crmco.crm

class SecuredCard {

	String number
	String cvv
	String expirationDate
	String ownerName
	SecuredCardType type
	Card card
	
    static constraints = {
    }
}
