<%@ page import="com.crmco.crm.Customer" %>



<div class="fieldcontain ${hasErrors(bean: customerInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="customer.firstName.label" default="First Name" />
		
	</label>
	<g:textField name="firstName" value="${customerInstance?.firstName}"/>
</div>

