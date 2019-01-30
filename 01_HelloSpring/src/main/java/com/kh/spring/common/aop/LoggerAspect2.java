package com.kh.spring.common.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect2 {
	
	Logger logger = Logger.getLogger(getClass());
	
	@Pointcut("execution(* com.kh.spring.memo..*(..))")
	public void pointCutForAll() {
		
	}
	
	/**
	 * AroundAdvice : 주업무 앞 뒤에서 실행된다.
	 * 
	 * Open Declaration org.aspectj.lang.annotation.Around
	 * @Target(value={METHOD}) 
	 * @Retention(value=RUNTIME)
	 */
	@Around("pointCutForAll()")
	public Object loggerAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		// 시그니처 가져오기. 실제로 실행될 메소드를 담고 있는 클래스이다.
		Signature signature = joinPoint.getSignature();
//		logger.debug("signature = " + signature);
		
		String type = signature.getDeclaringTypeName(); // 클래스명을 얻어온다.
		String methodName = signature.getName();
//		logger.debug("type = " + type);
//		logger.debug("methodName = " + methodName);
		
		String comp = "";
		
		// 클래스명에 indexOf("특정단어") 가 들어가 있냐? -1보다 크면 있다는 것.
		if(type.indexOf("Controller") > -1) {
			comp = "Controller \t: ";
		}
		else if(type.indexOf("Service") > -1) {
			comp = "Service \t: ";
		}
		else if(type.indexOf("Dao") > -1) {
			comp = "Dao \t: ";
		}
		
		logger.debug("[Before]" + comp + type + "." + methodName + "() 가 호출되었습니다.");
		
		Object obj = joinPoint.proceed();
		
		logger.debug("[After]" + comp + type + "." + methodName + "() 가 호출되었습니다.");
		
		return obj;
		
	}
}
