package com.nchu.library.web.wechat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front")
public class FrontController {
	
	 @RequestMapping(value = "/main")
	 private String main() {
		 return "html/main";
	 }
     
	 @RequestMapping(value = "/index")
	 private String index() {
		 return "html/index";
	 }
	 
	 @RequestMapping(value = "/volform")
	 private String volform() {
		 return "html/volform";
	 }
	 
	 @RequestMapping(value = "/lectureform")
	 private String lectureform() {
		 return "html/lectureform";
	 }
	 @RequestMapping(value = "/cupboard")
	 private String cupboard() {
		 return "html/cupboard";
	 }
	 @RequestMapping(value = "/myorder")
	 private String myorder() {
		 return "html/myorder";
	 }

}
