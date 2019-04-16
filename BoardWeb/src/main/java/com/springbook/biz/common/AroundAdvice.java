package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
	@Around("BeforeAdvice.allpointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object obj = pjp.proceed(); //포인트 컷(서비스 메소드)호출
		
		stopWatch.stop();
		
		System.out.println("[around]" + methodName + " : " + stopWatch.getTotalTimeMillis());
		return obj;
	}
}
