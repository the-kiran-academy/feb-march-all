package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.entity.User;
import com.jbk.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/add-user")
	public String addUserProcess(@ModelAttribute User user, Model model) {

		Boolean isAdded = userService.addUser(user);
		if (isAdded) {
			model.addAttribute("status", 1);
			model.addAttribute("msg", "User Added With UserName = " + user.getUserName());
			return "home";
		} else {
			model.addAttribute("status", 0);
			model.addAttribute("msg", "User Already Exists With UserName = " + user.getUserName());
			return "home";
		}

	}

	@PostMapping("/update-user")

	public ModelAndView updateUserProcess(@ModelAttribute User user, Model model) {

		Boolean isUpdated = userService.updateUser(user);

		if (isUpdated) {
			model.addAttribute("status", 1);
			model.addAttribute("msg", "Profile Updated");
			return new ModelAndView("home");
		} else {
			model.addAttribute("status", 0);
			model.addAttribute("msg", "Profile Not Updated");
			return new ModelAndView("home");
		}

	}

	@GetMapping("/get-user-by-id")
	public String getUserById(@RequestParam("username") String username, Model model) {

		User user = userService.getUserById(username);
		model.addAttribute("user", user);
		return "profile";

	}

}
