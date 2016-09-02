package com.example.exception;

public class DuplicationException extends ServiceFailException{
	public DuplicationException(int id){
		super(id+"는 이미 사용중 입니다.");
	}
}
