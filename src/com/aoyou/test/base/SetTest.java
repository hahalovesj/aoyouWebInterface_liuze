package com.aoyou.test.base;

public interface SetTest {

	void setURI();
	void setHeaders();
	void initParams();
	void setParams(String key,String value);
	void setRequestData();
	void sendPost();
	String getResponseString();
	int getStatus();
	String getRequestData();
}
