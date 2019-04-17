package com.springbook.biz.user;

import java.util.List;
import java.util.Map;

import com.springbook.biz.user.UserVO;

public interface Userservice {
	
	//CRUD 기능의 메소드 구현
	//회원 등록
	UserVO getUser(UserVO vo);
	List<UserVO> getUserList();
	public Integer userCount();
	public List<Map<String,Object>> getUserMap(UserVO vo);
}
