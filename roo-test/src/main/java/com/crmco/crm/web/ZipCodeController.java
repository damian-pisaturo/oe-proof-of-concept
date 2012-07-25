package com.crmco.crm.web;

import com.crmco.crm.model.ZipCode;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/zipcodes")
@Controller
@RooWebScaffold(path = "zipcodes", formBackingObject = ZipCode.class)
public class ZipCodeController {
}
