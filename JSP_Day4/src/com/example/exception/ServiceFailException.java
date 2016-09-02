package com.example.exception;

public class ServiceFailException extends Exception {
	public ServiceFailException(String msg){
		super(msg);
	}
}
