package com.aoyou.test.templates;

import java.io.File;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.*;
import com.aoyou.test.base.*;
import com.aoyou.test.util.Common;
import com.aoyou.test.util.Log;
import com.aoyou.test.util.ParseXmlString;
import com.aoyou.test.util.SendHttpClient;


public abstract class RestServiceTemplate implements SetTest{
	
	//接口地址
	protected String uri;
	//回传报文
	protected String responseString = "";
	//http请求代码
	protected int status = 0;
	//http --headers
	protected Map<String,String> headers = new HashMap<String,String>();
	//参数
	protected IdentityHashMap<String,String> params = new IdentityHashMap<String,String>();
	//请求报文串
	protected StringBuffer requestData = new StringBuffer("");
	//方法名
	protected String methodName;
	//入参对象
	public Object paramModel;
	//加密串，使用memberid等加密生成,后期加入自动生成case
	public static String encryString="ndaxhHifZ+wC1hUi@qV2YQ==";
	//接口版本,默认app3.5
	protected  String version="app3.5";
	//执行时间
	protected int runTime;
	//结果对象
	protected Object resultModel;
	@SuppressWarnings("rawtypes")
	private Class c;
	
	
	
	public RestServiceTemplate(){
		//获取方法版本
		setMethodVersion();
		//获取方法名
		getMethodName();
		//设置接口地址
		setURI();
		//初始化参数
		initParams();
		//初始化头
		this.headers.put("Content-Type", "application/json");
	}
	
	//获取接口方法名
	public  void getMethodName(){
		String className=this.getClass().getSimpleName();
		this.methodName=className.substring(0, className.lastIndexOf("R"));
	}
	
	//设置接口地址
	public  void setURI(){
		ParseXmlString pxs=new ParseXmlString();
		String url="";
		try {
			//读取配置文件
			pxs.Load(new File("config\\app.xml"));
			//接口地址
			url=pxs.getElementText("//url[@version='"+this.version+"']").trim();
			//方法resource
			String resource=pxs.getElementObject("//method[@name='"+this.methodName+"']").attributeValue("resource").trim();
			this.uri=Common.getFormatUriString(url, resource);
			//System.out.println(this.uri);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logError("接口地址错误，当前地址为:"+url);
			return;
		}	
	}
	
	//设置调用信息头
	public  void setHeaders(){
		String jsonString=this.requestData.toString();	
		//当入参中存在memberid时，需在user-agent中拼接经过加密的串
		if(jsonString.toUpperCase().contains("MEMBERID")){
			this.headers.put("User-Agent", "android30006/0C90D127E82ECE14DC470FF5F7549487/"+Common.getDeviceID()+"/"+encryString+"/");
		}else{
			this.headers.put("User-Agent", "android30006/0C90D127E82ECE14DC470FF5F7549487/"+Common.getDeviceID()+"/5app09kQLIV2FTHs2OKbtg==/");
		}
	}
	
	//加载参数
	public abstract void initParams();
	
	//获取方法版本
	public abstract void setMethodVersion();
	
	//设置调用参数
	public  void setRequestData(){
		Gson gson=new Gson();
		String paramString=gson.toJson(paramModel);
		System.out.println(paramString);
		this.requestData.append(paramString);
	}
	
	//发送请求
	public void sendPost() {
		setRequestData();
		//设置header列表
		setHeaders();
		List<Object> responses  = SendHttpClient.sendPost4WS(uri, headers, requestData);
		status = (int) responses.get(0);
		responseString = responses.get(1).toString();
		runTime=Integer.parseInt(responses.get(2).toString());
	}

	//获取回传报文串
	public String getResponseString() {
		return responseString;
	}
	
	//获取回传http请求zhua
	public int getStatus() {
		return status;
	}
	
	public void setParams(String key, String value){			
	}
	
	//获取请求报文串
	public String getRequestData() {
		return requestData.toString();		
	}
	
	//获取请求泛型对象
	@SuppressWarnings("unchecked")
	public <T> T getRequestParamMode(){
		return (T)paramModel;
	}
	
	//获取执行时间
	public int getRunTime(){
		return this.runTime;
	}
	
	//装在结果对象
	 public void setResultObject(String responseString) throws InstantiationException, IllegalAccessException{
		try {
			c = Class.forName("com.aoyou.test.app.Result.model."+this.methodName+"Result");
			Gson gson=new Gson();
			resultModel=c.newInstance();
			@SuppressWarnings("unchecked")
			Object fromJson = gson.fromJson(this.responseString, c);
			resultModel=fromJson;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 //获取回传结果对象
	 public Object getResponseMode() {
		try {
			setResultObject(responseString);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.resultModel;
	} 
}
