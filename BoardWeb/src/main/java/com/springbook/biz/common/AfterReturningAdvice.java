package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut="BeforeAdvice.allpointcut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		System.out.println("[사후 처리]" + methodName +  " : " + 
		(returnObj != null ? returnObj : ""));
	}
}
