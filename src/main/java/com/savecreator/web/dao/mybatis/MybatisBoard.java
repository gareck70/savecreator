package com.savecreator.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.savecreator.web.dao.BoardDao;
import com.savecreator.web.entity.Board;

public class MybatisBoard implements BoardDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Board> getBoardList() {
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		return boardDao.getBoardList();
		
	}
}
