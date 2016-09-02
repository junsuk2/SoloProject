package com.example.exception;


public class UserNotFoundException extends ServiceFailException{
	
	public UserNotFoundException(int id){
		super(id+"로는 로그인 할 수 없습니다.");
	}
}
