package com.savecreator.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.savecreator.web.dao.BoardDao;
import com.savecreator.web.entity.Board;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("notice-list")
	public String noticelist(Model model) {
		List<Board> board = boardDao.getBoardList();
		model.addAttribute("Board", board);
		
		return "notice.notice-list";
	}
	
	
	@RequestMapping("notice-edit")
	public String noticeedit() {
		 
		return "notice.notice-edit";
	}
}