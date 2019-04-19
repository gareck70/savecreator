package com.savecreator.web.service;

import java.util.List;

import com.savecreator.web.dao.BoardDao;
import com.savecreator.web.entity.Board;


public class BoardService {

	private BoardDao boardDao;

	public List<Board> getBoardList(){
		return boardDao.getBoardList();
	}

}
