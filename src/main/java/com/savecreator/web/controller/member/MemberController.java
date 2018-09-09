package com.savecreator.web.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.savecreator.web.entity.Question;

@Controller("memberController")
@RequestMapping("/member/")
public class MemberController {

	
	@RequestMapping("index")
	public String main(Model model) {
		
		return "member.index";
	}
}

	