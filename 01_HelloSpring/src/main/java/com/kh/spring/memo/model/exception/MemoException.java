package com.kh.spring.memo.model.exception;

/**
 *  스프링에서는 체크드 익셉션 안 좋아한다. 
 *	내부적으로 체크드 익셉션일지라도 예외처리한담에 런타임 익셉션.. 언체크드 익셉션으로 던져주는걸 좋아한다.
 *  언체크드로 커밋 롤백을 정한다. 런타임익셉션으로 만드세요
 */
public class MemoException extends RuntimeException {
	
	 

	public MemoException() {
		super();
	}

	public MemoException(String message, Throwable cause) {
		super(message, cause);
	}

	public MemoException(String message) {
		super(message);
	}

	public MemoException(Throwable cause) {
		super(cause);
	}
	
	
}
