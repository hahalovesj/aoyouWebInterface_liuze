package com.aoyou.test.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendHurc {

	private String responseString = "";
	private int status = 0;
	private String url;
	private Map<String,Object> requestProperty = new HashMap<String,Object>();
	private List<String> requestData = new ArrayList<String>();
	private StringBuffer soapRequestData = new StringBuffer();
	
	public SendHurc(String url){
		this.url = url;
	}
	
	private void requestListToBuffer(){
	
		if (requestData != null && requestData.size() > 0) { 		
			soapRequestData.delete(0, soapRequestData.length()+1);
            for (int i = 0; i < requestData.size(); i++) {  
                if (requestData.get(i) == null || requestData.get(i) == "") {  
                    continue;  
                }  
                // 如果值是list类型则调用自己  
                if (requestData  instanceof List) {  
                	soapRequestData.append(requestData.get(i));  
                } else {System.out.println("入参不是List类型！");}  
            }
		} 
	}
	
	/**
	 * @Description 得到前一个http请求的响应报文，返回格式为xml格式的字符串
	 */
	public String getResponseString(){
		return responseString;	
	}
	
	/**
	 * @Description 得到前一个http请求的状态码，返回格式int
	 */
	public int getStatus(){
		return status;	
	}
	
	/**
	 * @Description 得到当前准备发送的http请求的属性信息，返回格式Map
	 */
	public Map<String,Object> getRequestProperty(){
		return requestProperty;	
	}
	
	/**
	 * @Description 得到当前准备发送的http所有入参信息，返回格式字符串
	 */
	public String getRequestData(){
		return soapRequestData.toString();	
	}
	
	public List<String> getRequestDataList(){
		return	requestData;
	}
	
	/**
	 * @Description 添加http请求的属性信息
	 */
	public void addRequestProperty(String key,String value){
		requestProperty.put(key, value);
	}
	
	/**
	 * @Description 删除http请求的属性信息
	 */
	public void deleteRequestProperty(String key){
		
		for(String k:requestProperty.keySet()){
			if(k.equals(key)){
				requestProperty.remove(key);
			}else System.out.println("RequestProperty，要删除的key值不存在！");
		}
	}
	
	/**
	 * @Description 更新已存在的http请求属性信息
	 */
	public void updateRequestProperty(String key,String newValue){
		
		int flag = 0;
		
		for(String k:requestProperty.keySet()){
			if(k.equals(key)){
				requestProperty.put(key, newValue);
				flag++;
			}
			
		if(flag==0){
			System.out.println("RequestProperty，要更新的key值不存在！");
		}
		
		}
	}
	
	/**
	 * @Description 新增已存在的所有http请求入参
	 */
	public void clearRequestProperty(){
		requestProperty.clear();
	}
	
	/**
	 * @Description 添加http请求入参
	 */
	public void addRequestData(String data){
		requestData.add(data);
	}
	
	/**
	 * @Description 在data目录下名为fileName的Txt文件中存储请求入参
	 */
	public void addRequestDataFromText(String filepath){
		
		File file=new File(filepath);
		if(file.exists()){
			ParseTxt pt = new ParseTxt(filepath);		
			soapRequestData.append(pt.readByLinesToString());
		}else Log.logError(filepath+"文件不存在！");
	}
	
	/**
	 * @Description 更新http请求入参
	 */
	public void updateRequestData(String data,String newData){
		
		for(int i=0;i<requestData.size();i++){
			if(requestData.get(i).equals(data)){
				requestData.set(i, newData);	
			}
		}	
	}
	
	/**
	 * @Description 清空已存在的所有http请求入参
	 */
	public void clearRequestData(){
		soapRequestData.delete(0, soapRequestData.length());
	}
	
	/** 
	 *@Description 发送get请求，将响应报文以字符串形式储存在responseString.调用结束返回状态布尔值
	 */
	public boolean sendGet(){
		
		BufferedReader br = null;
		Boolean flag = false;
		responseString = "";
		status = 0;
		
		try {
			String urlNameString = url + "?" + soapRequestData.toString();
			URL Url = new URL(urlNameString);
			HttpURLConnection hurc = (HttpURLConnection)Url.openConnection();

			hurc.setUseCaches(false);
			hurc.setInstanceFollowRedirects(true);
			hurc.setRequestMethod("GET");
			
			for (String key : requestProperty.keySet()){
				hurc.setRequestProperty(key, requestProperty.get(key).toString()); 
			}
			
			hurc.connect();
			status = hurc.getResponseCode();
			InputStream in = hurc.getInputStream();
			br = new BufferedReader(new InputStreamReader(in));
			String line;
			
			while((line=br.readLine())!=null){
				responseString+=line;
			}
				
		} catch (Exception ex) {Log.logError("发送GET请求出现异常！"+ex);}
		
		finally{
			
            try {
                if (br != null) {
                	br.close();
                }
            } catch (Exception ex) {Log.logError("关闭IO流出现异常！"+ex);}
		}
		
		if(responseString!=""){
			flag = true;
		}
		return flag;	
	}

	/**
	 *@Description 发送post请求，将响应报文以字符串形式储存在responseString.调用结束返回状态布尔值
	 */
	public boolean sendPost4WS(){
		
		OutputStreamWriter out = null;
		BufferedReader br = null;
		Boolean flag = false;
		responseString = "";
		status = 0;

		try{			
			URL Url = new URL(url);	
			HttpURLConnection hurc = (HttpURLConnection) Url.openConnection();
			
			hurc.setDoInput(true);
			hurc.setDoOutput(true);
			hurc.setUseCaches(false);
			hurc.setInstanceFollowRedirects(true);
			hurc.setRequestMethod("POST");
			
			for (String key : requestProperty.keySet()){
				hurc.setRequestProperty(key, requestProperty.get(key).toString()); 
			}
					
			hurc.connect();
			
			out = new OutputStreamWriter(hurc.getOutputStream(), "UTF-8");
			this.requestListToBuffer();
			out.append(soapRequestData.toString());
			out.flush();
			out.close();
			
			status = hurc.getResponseCode();
			InputStream in = hurc.getInputStream();			
			br = new BufferedReader(new InputStreamReader(in,"UTF-8"));	
			String line;		
			
			while((line=br.readLine())!=null){
				responseString+=line;
			}
			  
		}catch(Exception ex){Log.logError("发送POST请求出现异常！"+ex);}
		
		finally{
			
			try {
				if(out!=null){
					out.close();
				}
				
				if(br!=null){
					br.close();
				}
			} catch (Exception ex) {Log.logError("关闭IO流出现异常！"+ex);}

		}
		
		if(responseString!=""){
			flag = true;
		}
		return flag;
		}
		 
}
