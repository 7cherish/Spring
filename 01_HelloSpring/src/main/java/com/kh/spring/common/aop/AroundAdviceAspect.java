package com.kh.spring.common.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Advice의 다섯가지타입
 * 
 * 1. Around Advice
 * 2. Before Advice
 * 3. After Advice
 * 4. AfterReturning Advice
 * 5. AfterThrowing Advice
 * 
 * @author nobodj
 *
 */
@Component
@Aspect
public class AroundAdviceAspect {
	private Logger logger = Logger.getLogger(getClass());
	
	// Impl로 끝나는 모든 클래스와 모든 메소드
//	@Pointcut("execution(* com.kh.spring.memo..*Controller.insert*(..))")
//	public void pointcut() {}
	
	
//	@Around("pointcut()")
	@Around("execution(* com.kh.spring.memo..*Controller.insert*(..))")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		String methodName = joinPoint.getSignature().getName();
		
		//Target메소드 실행전 코드 
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		
		Object obj = joinPoint.proceed();
		
		//Target메소드 실행후 코드 
		
		stopWatch.stop();
		
		logger.debug(methodName + "() 소요시간 : "  + stopWatch.getTotalTimeMillis() + "(ms)초");
		
		return obj;
	}
}
