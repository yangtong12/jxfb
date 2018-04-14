package com.nchu.chjxfb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front")
public class LoginController {
	
	@RequestMapping("/login")
	private String login() {
		return "login";
	}

}
