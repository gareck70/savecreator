package com.savecreator.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@RequestMapping("notice-list")
	public String noticelist(Model model) {
		
		
		return "notice.notice-list";
	}
	
	
	@RequestMapping("notice-edit")
	public String noticeedit() {
		 
		return "notice.notice-edit";
	}
}