package com.crmco.crm.model;

import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RooIntegrationTest(entity = Customer.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager1")
public class CustomerIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }
}
