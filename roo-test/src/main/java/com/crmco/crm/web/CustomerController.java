package com.crmco.crm.web;

import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crmco.crm.model.Customer;

@RequestMapping("/customers")
@Controller
@RooWebScaffold(path = "customers", formBackingObject = Customer.class)
@RooWebJson(jsonObject = Customer.class)
public class CustomerController {
	
	@RequestMapping(params = "async", produces = "text/html")
    public String testAsync(Model uiModel) {
		System.out.println("-------------------> Before calling async method");
		doSomethingAync("hello async world!");
		System.out.println("-------------------> After calling async method");
		return "redirect:/customers";
    }
	
	@Async
	private void doSomethingAync(String s) {
		try {
			Thread.sleep(5000);
			System.out.println("------------------> Async printing");
			System.out.println(s);
			System.out.println("<------------------ End of async printing");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
