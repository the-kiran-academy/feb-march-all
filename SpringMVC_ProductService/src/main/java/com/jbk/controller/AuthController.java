package com.jbk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jbk.entity.User;
import com.jbk.service.AuthService;

@Controller
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping(value = "/login") // request comes from front-end
	public String loginProcess(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model,HttpSession session) {

		User user = authService.loginProcess(username, password);

		if (user != null) {
			
			session.setAttribute("username", username);
			
			return "home";
		} else {

			// response to front -end
			model.addAttribute("msg", "Invalid Credientials !!");
			return "login";
		}

	}

}
