package com.aoyou.test.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


public class SendHttpClient {

	/**
	 * @param url 接口地址
	 * @param headers 请求报文的头信息
	 * @param param 请求参数
	 * @return String 响应报文
	 */
	public static List<Object> sendPost4WS(String url,Map<String,String> headers,StringBuffer param){
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
		String responseString="";
		List<Object> results = new ArrayList<Object>();
		
		for(String key:headers.keySet()){
			httppost.setHeader(key,headers.get(key));
		}
		
		try {
			HttpEntity re = new StringEntity(param.toString(),HTTP.UTF_8);
			httppost.setEntity(re);
			Date start_date=new Date();
			HttpResponse response = httpclient.execute(httppost); 
			Date end_date=new Date();
			responseString = EntityUtils.toString(response.getEntity()); 
			results.add(response.getStatusLine().getStatusCode());
			results.add(responseString);
			results.add(end_date.getTime()-start_date.getTime());
			
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (ClientProtocolException e2){
			e2.printStackTrace();
		} catch(IOException e3){
			e3.printStackTrace();
		}
		finally{  
            httpclient.getConnectionManager().shutdown();  
        }  
		return results;
		
	}
		
	public static String sendPost4WS(String url,Map<String,String> headers,String param){
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
		String responseString="";
		
		for(String key:headers.keySet()){
			httppost.setHeader(key,headers.get(key));
		}
		
		try {
			HttpEntity re = new StringEntity(param,HTTP.UTF_8);
			httppost.setEntity(re);
			HttpResponse response = httpclient.execute(httppost); 
			responseString = EntityUtils.toString(response.getEntity()); 		
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (ClientProtocolException e2){
			e2.printStackTrace();
		} catch(IOException e3){
			e3.printStackTrace();
		}
		finally{  
            httpclient.getConnectionManager().shutdown();  
        }  
		return responseString;
		
	}
	
}
