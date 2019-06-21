package com.savecreator.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.savecreator.dao.LoginDao;
import com.savecreator.web.entity.User;
@Repository
public class MybatisLoginDao implements LoginDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertSignup(User user) {
		LoginDao loginDao = sqlSession.getMapper(LoginDao.class);
		return loginDao.insertSignup(user);
	}

}
