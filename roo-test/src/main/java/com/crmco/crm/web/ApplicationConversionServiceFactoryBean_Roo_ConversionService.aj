// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.crmco.crm.web;

import com.crmco.crm.model.Customer;
import com.crmco.crm.model.ZipCode;
import com.crmco.crm.web.ApplicationConversionServiceFactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    public Converter<Customer, String> ApplicationConversionServiceFactoryBean.getCustomerToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.crmco.crm.model.Customer, java.lang.String>() {
            public String convert(Customer customer) {
                return new StringBuilder().append(customer.getFirstName()).toString();
            }
        };
    }
    
    public Converter<Long, Customer> ApplicationConversionServiceFactoryBean.getIdToCustomerConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.crmco.crm.model.Customer>() {
            public com.crmco.crm.model.Customer convert(java.lang.Long id) {
                return Customer.findCustomer(id);
            }
        };
    }
    
    public Converter<String, Customer> ApplicationConversionServiceFactoryBean.getStringToCustomerConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.crmco.crm.model.Customer>() {
            public com.crmco.crm.model.Customer convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Customer.class);
            }
        };
    }
    
    public Converter<ZipCode, String> ApplicationConversionServiceFactoryBean.getZipCodeToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.crmco.crm.model.ZipCode, java.lang.String>() {
            public String convert(ZipCode zipCode) {
                return new StringBuilder().append(zipCode.getCode()).toString();
            }
        };
    }
    
    public Converter<Long, ZipCode> ApplicationConversionServiceFactoryBean.getIdToZipCodeConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.crmco.crm.model.ZipCode>() {
            public com.crmco.crm.model.ZipCode convert(java.lang.Long id) {
                return ZipCode.findZipCode(id);
            }
        };
    }
    
    public Converter<String, ZipCode> ApplicationConversionServiceFactoryBean.getStringToZipCodeConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.crmco.crm.model.ZipCode>() {
            public com.crmco.crm.model.ZipCode convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), ZipCode.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getCustomerToStringConverter());
        registry.addConverter(getIdToCustomerConverter());
        registry.addConverter(getStringToCustomerConverter());
        registry.addConverter(getZipCodeToStringConverter());
        registry.addConverter(getIdToZipCodeConverter());
        registry.addConverter(getStringToZipCodeConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
