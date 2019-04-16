package com.springbook.biz;

import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl2 implements HomeService{

	@Override
	public void print() {
		System.out.println("HomeServiceIpml2 실행");
	}
}
