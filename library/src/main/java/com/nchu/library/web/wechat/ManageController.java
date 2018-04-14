package com.nchu.library.web.wechat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class ManageController {
	
	@RequestMapping(value = "/backmanage")
	 private String cupboard() {
		 return "html/backmanage";
	 }
	
	@RequestMapping(value = "/orderactivity")
	 private String orderactivity() {
		 return "html/orderactivity";
	 }
	
	@RequestMapping(value = "/orderdetails")
	 private String orderdetails() {
		 return "html/orderdetails";
	 }
	
	@RequestMapping(value = "/systemset")
	 private String systemset() {
		 return "html/systemset";
	 }
    @RequestMapping(value="/actitableedit")
    private String actitableedit() {
    	return "html/actitableedit";
    }
    
    
    @RequestMapping(value="/detatableedit")
    private String detatableedit() {
    	return "html/detatableedit";
    }
    @RequestMapping(value="/addactibtn")
    private String addactibtn() {
    	return "html/addactibtn";
    }
    @RequestMapping(value="/adddetbtn")
    private String adddetbtn() {
    	return "html/adddetbtn";
    }
}
