package com.crmco.crm.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class ZipCode {
	
	@PersistenceContext(unitName="persistenceUnit2")
	transient EntityManager entityManager;

    @NotNull
    private String code;
}
