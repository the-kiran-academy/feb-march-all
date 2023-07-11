package com.jbk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	
	@RequestMapping(value ="/")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value ="/add-user-page")
	public String addUserPage() {
		return "add-user";
	}
	
	@RequestMapping(value ="/add-product-page")
	public String addProductPage() {
		return "add-product";
	}
	
	@RequestMapping(value ="/home-page")
	public String homePage() {
		return "home";
	}
	

}
