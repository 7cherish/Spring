package com.kh.spring.common.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class LoggerAspect {
	
	Logger logger = Logger.getLogger(getClass());
	
	/**
	 * AroundAdvice : 주업무 앞 뒤에서 실행된다.
	 */
	public Object loggerAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		// 시그니처 가져오기. 실제로 실행될 메소드를 담고 있는 클래스이다.
		Signature signature = joinPoint.getSignature();
		logger.debug("signature = " + signature);
		
		String type = signature.getDeclaringTypeName(); // 클래스를 얻어온다.
		String methodName = signature.getName();
		logger.debug("type = " + type);
		logger.debug("methodName = " + methodName);
		
		return joinPoint.proceed();
		
	}
}
