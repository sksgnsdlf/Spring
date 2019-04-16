package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
//advice 클래스
public class BeforeAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))" )
	public void allpointcut() {}
	
	@Before("allpointcut()")
	public void beforeLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[사전 처리] " + methodName + " 비즈니스 로직 수행 전 동작" + 
		((args!=null && args.length>0) ? args[0] : ""));
	}
}
