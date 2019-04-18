package com.savecreator.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@RequestMapping("notice-list")
	public String noticelist() {
		 
		return "notice.notice-list"; 
	}

	
}
