package com.crmco.crm

import org.springframework.dao.DataIntegrityViolationException

/**
 * Controller with static scaffolding.
 * 
 * @author Damian Pisaturo
 *
 */
class CustomerController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [customerInstanceList: Customer.list(params), customerInstanceTotal: Customer.count()]
    }

    def create() {
        [customerInstance: new Customer(params)]
    }

    def save() {
        def customerInstance = new Customer(params)
        if (!customerInstance.save(flush: true)) {
            render(view: "create", model: [customerInstance: customerInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'customer.label', default: 'Customer'), customerInstance.id])
        redirect(action: "show", id: customerInstance.id)
    }

    def show(Long id) {
        def customerInstance = Customer.get(id)
        if (!customerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'customer.label', default: 'Customer'), id])
            redirect(action: "list")
            return
        }

        [customerInstance: customerInstance]
    }

    def edit(Long id) {
        def customerInstance = Customer.get(id)
        if (!customerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'customer.label', default: 'Customer'), id])
            redirect(action: "list")
            return
        }

        [customerInstance: customerInstance]
    }

    def update(Long id, Long version) {
        def customerInstance = Customer.get(id)
        if (!customerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'customer.label', default: 'Customer'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (customerInstance.version > version) {
                customerInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'customer.label', default: 'Customer')] as Object[],
                          "Another user has updated this Customer while you were editing")
                render(view: "edit", model: [customerInstance: customerInstance])
                return
            }
        }

        customerInstance.properties = params

        if (!customerInstance.save(flush: true)) {
            render(view: "edit", model: [customerInstance: customerInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'customer.label', default: 'Customer'), customerInstance.id])
        redirect(action: "show", id: customerInstance.id)
    }

    def delete(Long id) {
        def customerInstance = Customer.get(id)
        if (!customerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'customer.label', default: 'Customer'), id])
            redirect(action: "list")
            return
        }

        try {
            customerInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'customer.label', default: 'Customer'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'customer.label', default: 'Customer'), id])
            redirect(action: "show", id: id)
        }
    }
}
