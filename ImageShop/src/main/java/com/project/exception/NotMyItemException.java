package com.project.exception;

public class NotMyItemException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotMyItemException(String msg){
		super(msg);
	}
	
}
