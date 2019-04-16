package com.springbook.biz;

import org.springframework.stereotype.Service;

//@Service
public class HomeServiceImpl1 implements HomeService{

	@Override
	public void print() {
		System.out.println("HomeServiceIpml1 실행");
	}
}
