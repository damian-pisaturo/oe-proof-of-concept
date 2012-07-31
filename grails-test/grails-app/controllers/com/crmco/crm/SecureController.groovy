package com.crmco.crm

import grails.plugins.springsecurity.Secured

class SecureController {

	//You can annotate the entire controller or individual actions.
	@Secured(["hasRole('ROLE_ADMIN')"])
    def index() {
		render 'Secure access only'
	}
}
