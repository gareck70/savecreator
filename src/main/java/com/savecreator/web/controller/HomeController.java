package com.savecreator.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.savecreator.web.entity.Question;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("index")
	public String main(Model model) {
		
		return "home.index";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "home.login";
	}
	
	/*@RequestMapping("type")
	public String type(Model model) {
		
		model.addAttribute("test","Hello");
		return "admin.question.type";
	}

	@GetMapping("reg")
	//@RequestMapping(value ="reg", method=RequestMethod.GET)
	public String reg(Model model) {
		
		model.addAttribute("reg","Hello");
		return "admin.question.reg";
		

	}
	@PostMapping("reg")
//	@RequestMapping("reg" method=RequestMethod.POST)
	public String reg(Question question) {
		
		return "redirect.type";*/
		

	}

