package com.springbook.biz.emp.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.emp.DeptVO;

@Repository //빈등록
public class DeptDAO {

	@Autowired
	SqlSessionTemplate mybatis;
	//등록
	public void insertDept(DeptVO vo) {
		mybatis.insert("emp.insertDept",vo);
	}
	//수정
	public void updateDept(DeptVO vo) {
		mybatis.update("emp.updateDept",vo);
	}
	//삭제
	public void deleteDept(DeptVO vo) {
		mybatis.delete("emp.deleteDept",vo);
	}
	//단건조회
	public DeptVO getDept(DeptVO vo) {
		return mybatis.selectOne("emp.getDept",vo);
	}
	
	//전체건수
	public Integer getCount() {
		return mybatis.selectOne("emp.getCount");
	}
	
	//부서별 인원수
	public List<Map<String,Object>> getDeptCnt(){
		return mybatis.selectList("emp.getDeptCnt");
	}
}
