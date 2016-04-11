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
	
	//�ӿڵ�ַ
	protected String uri;
	//�ش�����
	protected String responseString = "";
	//http�������
	protected int status = 0;
	//http --headers
	protected Map<String,String> headers = new HashMap<String,String>();
	//����
	protected IdentityHashMap<String,String> params = new IdentityHashMap<String,String>();
	//�����Ĵ�
	protected StringBuffer requestData = new StringBuffer("");
	//������
	protected String methodName;
	//��ζ���
	public Object paramModel;
	//���ܴ���ʹ��memberid�ȼ�������,���ڼ����Զ�����case
	public static String encryString="ndaxhHifZ+wC1hUi@qV2YQ==";
	//�ӿڰ汾,Ĭ��app3.5
	protected  String version="app3.5";
	//ִ��ʱ��
	protected int runTime;
	//�������
	protected Object resultModel;
	@SuppressWarnings("rawtypes")
	private Class c;
	
	
	
	public RestServiceTemplate(){
		//��ȡ�����汾
		setMethodVersion();
		//��ȡ������
		getMethodName();
		//���ýӿڵ�ַ
		setURI();
		//��ʼ������
		initParams();
		//��ʼ��ͷ
		this.headers.put("Content-Type", "application/json");
	}
	
	//��ȡ�ӿڷ�����
	public  void getMethodName(){
		String className=this.getClass().getSimpleName();
		this.methodName=className.substring(0, className.lastIndexOf("R"));
	}
	
	//���ýӿڵ�ַ
	public  void setURI(){
		ParseXmlString pxs=new ParseXmlString();
		String url="";
		try {
			//��ȡ�����ļ�
			pxs.Load(new File("config\\app.xml"));
			//�ӿڵ�ַ
			url=pxs.getElementText("//url[@version='"+this.version+"']").trim();
			//����resource
			String resource=pxs.getElementObject("//method[@name='"+this.methodName+"']").attributeValue("resource").trim();
			this.uri=Common.getFormatUriString(url, resource);
			//System.out.println(this.uri);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logError("�ӿڵ�ַ���󣬵�ǰ��ַΪ:"+url);
			return;
		}	
	}
	
	//���õ�����Ϣͷ
	public  void setHeaders(){
		String jsonString=this.requestData.toString();	
		//������д���memberidʱ������user-agent��ƴ�Ӿ������ܵĴ�
		if(jsonString.toUpperCase().contains("MEMBERID")){
			this.headers.put("User-Agent", "android30006/0C90D127E82ECE14DC470FF5F7549487/"+Common.getDeviceID()+"/"+encryString+"/");
		}else{
			this.headers.put("User-Agent", "android30006/0C90D127E82ECE14DC470FF5F7549487/"+Common.getDeviceID()+"/5app09kQLIV2FTHs2OKbtg==/");
		}
	}
	
	//���ز���
	public abstract void initParams();
	
	//��ȡ�����汾
	public abstract void setMethodVersion();
	
	//���õ��ò���
	public  void setRequestData(){
		Gson gson=new Gson();
		String paramString=gson.toJson(paramModel);
		System.out.println(paramString);
		this.requestData.append(paramString);
	}
	
	//��������
	public void sendPost() {
		setRequestData();
		//����header�б�
		setHeaders();
		List<Object> responses  = SendHttpClient.sendPost4WS(uri, headers, requestData);
		status = (int) responses.get(0);
		responseString = responses.get(1).toString();
		runTime=Integer.parseInt(responses.get(2).toString());
	}

	//��ȡ�ش����Ĵ�
	public String getResponseString() {
		return responseString;
	}
	
	//��ȡ�ش�http����zhua
	public int getStatus() {
		return status;
	}
	
	public void setParams(String key, String value){			
	}
	
	//��ȡ�����Ĵ�
	public String getRequestData() {
		return requestData.toString();		
	}
	
	//��ȡ�����Ͷ���
	@SuppressWarnings("unchecked")
	public <T> T getRequestParamMode(){
		return (T)paramModel;
	}
	
	//��ȡִ��ʱ��
	public int getRunTime(){
		return this.runTime;
	}
	
	//װ�ڽ������
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
	 
	 //��ȡ�ش��������
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
