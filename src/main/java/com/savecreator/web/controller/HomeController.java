 package com.savecreator.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.savecreator.web.entity.User;
import com.savecreator.web.service.LoginDaoImpl;


@Controller

@RequestMapping("/")
public class HomeController {
	
	@Autowired
	LoginDaoImpl service;
	
	@RequestMapping("index")
	public String main(Model model) {
		return "home.index";
	}

	
	@RequestMapping("signup")
	public String signup(Model model, User user) {
		
		service.insertSignup(user);
		
		return "home.signup";
	}
	@RequestMapping("login")
	public String login(Model model, @RequestParam(value ="idx") String idx,
		@RequestParam(value = "pwd") String pwd	,HttpSession session){
		
		return "home.login";
	}
	
}

