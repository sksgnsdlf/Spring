package com.springbook.biz.user.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository
public class UserDAOMybatis {
	@Autowired SqlSessionTemplate mybatis;
	
	//단건조회
	public UserVO getUser(UserVO vo) {
		return mybatis.selectOne("UserDAO.getUser", vo);
	}
	
	//전체조회
	public List<UserVO> getUserList(){
		return mybatis.selectList("UserDAO.getUserList");
	}
	
	//user인원수
	public Integer userCount() {
		return mybatis.selectOne("UserDAO.userCount");
	}
	
	//user인원수를 map으로
	public List<Map<String,Object>> getUserMap(UserVO vo){
		return mybatis.selectList("UserDAO.getUserMap",vo);
	}
}
