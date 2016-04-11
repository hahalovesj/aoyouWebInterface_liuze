package com.aoyou.test.templates;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import com.aoyou.test.base.SetTest;
import com.aoyou.test.util.SendHttpClient;

public abstract class WebSerivceTemplate  implements SetTest{
	
	protected String uri;
	protected String responseString = "";
	protected int status = 0;
	protected Map<String,String> headers = new HashMap<String,String>();
	protected IdentityHashMap<String,String> params = new IdentityHashMap<String,String>();
	protected StringBuffer requestData = new StringBuffer();
	
	
	public WebSerivceTemplate(){
		setURI();
		setHeaders();
		initParams();
		headers.put("Content-Type", "text/xml");
	}
	
	public abstract void setURI();

	public abstract void setHeaders();

	public abstract void initParams();

	public void setParams(String key, String value){	
		int flag = 0;		
		for(String k:params.keySet()){
			if(k.equals(key)){
				params.put(key, value);
				flag++;
			}
		}	
		if(flag==0){
			System.out.println("Params，要更新的key值："+key+" 不存在！");
		}
	}
	
	public abstract void setRequestData();
	
	public void sendPost() {
		setURI();
		setHeaders();
		setRequestData();
		List<Object> responses  = SendHttpClient.sendPost4WS(uri, headers, requestData);
		status = (int) responses.get(0);
		responseString = responses.get(1).toString();
	}

	public String getResponseString() {
		return responseString;
	}
	
	public int getStatus() {
		return status;
	}
	
	public String getRequestData() {
		return requestData.toString();		
	}
	
}
