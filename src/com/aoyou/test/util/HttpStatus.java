package com.aoyou.test.util;

public enum HttpStatus {

	OK(200),NOT_FOUND(404);
	
	private int _value;
	
	private HttpStatus(int value){
		this._value=value;
	}
	
	public int value(){
		return _value;
	}
}
