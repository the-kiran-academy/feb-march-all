package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jbk.entity.Product;
import com.jbk.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add-product")
	public String addProductProcess(@ModelAttribute Product product,Model model) {
		
		Boolean isAdded = productService.addProduct(product);
		if(isAdded) {
			model.addAttribute("msg", "Product Added With Name = "+product.getProductName());
			return "home";
		}else {
			model.addAttribute("msg", "Product Already Exists With Name = "+product.getProductName());
			return "home";
		}
		
		
	}

}
