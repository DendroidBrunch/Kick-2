package com.zhylko.secondtask.exception;

public class TextCompositeException extends Exception{
	public TextCompositeException() {
		super();
	}
	
	public TextCompositeException(String message) {
		super(message);
	}
	
	public TextCompositeException(Throwable cause) {
		super(cause);
	}
	
	public TextCompositeException(String message, Throwable cause) {
		super(message, cause);
	}
}
