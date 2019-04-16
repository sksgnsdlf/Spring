package com.springbook.biz.user;

import com.springbook.biz.user.UserVO;

public interface Userservice {
	
	//CRUD 기능의 메소드 구현
	//회원 등록
	public UserVO getUser(UserVO vo);
}
