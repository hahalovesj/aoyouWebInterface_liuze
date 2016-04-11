package com.aoyou.test.templates;


public abstract class NoInputParamTemplate extends WebSerivceTemplate{
	
	@Override
	public void initParams() {
		params.clear();
	}
	
	@Override
	public void setParams(String key, String value) {
		params.put(key, value);
	}
	
}
