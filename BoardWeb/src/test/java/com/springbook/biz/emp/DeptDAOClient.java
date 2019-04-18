package com.springbook.biz.emp;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springbook.biz.emp.impl.DeptDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/applicationContext.xml",
								   "classpath:config/context-mapper.xml"})
public class DeptDAOClient {

	@Autowired
	DeptDAO dao;
	
	@Test
	public void test() {
		DeptVO vo = new DeptVO();
		vo.setDepartmentName("디자인팀1");
		dao.insertDept(vo);
		System.out.println("등록된 부서번호: " + vo.getDepartmentId());
	//	System.out.println(dao.getDept(vo));
	//	System.out.println(dao.getCount());
	//	System.out.println(dao.getDeptCnt());
//		List<Map<String,Object>> list = dao.getDeptCnt();
//		for(Map<String,Object> temp: list) {
//			System.out.println(temp.get("id")+ " : " + temp.get("name") + " : " + temp.get("cnt"));
//		}
	}

}
