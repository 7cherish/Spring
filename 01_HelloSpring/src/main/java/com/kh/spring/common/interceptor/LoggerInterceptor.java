package com.kh.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	Logger logger = Logger.getLogger(getClass());

	// 오버라이딩 할 메소드가 3개 정도 있다. (preHandle, postHandle, afterCompletion)
	// 어댑터는 오버라이딩을 미리 해놔서 하고 싶은 것만 하라고 하는 클래스이다.
	
	// controller로 보내기 전에 처리하는 인터셉터
	// 반환이 false라면 controller로 요청을 안함
	// 매개변수 Object는 핸들러 정보를 의미한다. ( RequestMapping , DefaultServletHandler )
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(logger.isDebugEnabled()) {
			logger.debug("========== Client Request ==========");
			logger.debug(request.getRequestURI()); // 어디서 요청했는지 확인
			logger.debug("------------------------------------");
		}
		return super.preHandle(request, response, handler);
	}
	
	// controller의 handler가 끝나면 처리됨
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(logger.isDebugEnabled()) {
			logger.debug("--------------- view --------------");
		}
	}
	
	// view까지 처리가 끝난 후에 처리됨
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if(logger.isDebugEnabled()) {
			logger.debug("=============== END ===============");
		}
		super.afterCompletion(request, response, handler, ex);
	}

}
