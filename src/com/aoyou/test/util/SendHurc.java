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
                // ���ֵ��list����������Լ�  
                if (requestData  instanceof List) {  
                	soapRequestData.append(requestData.get(i));  
                } else {System.out.println("��β���List���ͣ�");}  
            }
		} 
	}
	
	/**
	 * @Description �õ�ǰһ��http�������Ӧ���ģ����ظ�ʽΪxml��ʽ���ַ���
	 */
	public String getResponseString(){
		return responseString;	
	}
	
	/**
	 * @Description �õ�ǰһ��http�����״̬�룬���ظ�ʽint
	 */
	public int getStatus(){
		return status;	
	}
	
	/**
	 * @Description �õ���ǰ׼�����͵�http�����������Ϣ�����ظ�ʽMap
	 */
	public Map<String,Object> getRequestProperty(){
		return requestProperty;	
	}
	
	/**
	 * @Description �õ���ǰ׼�����͵�http���������Ϣ�����ظ�ʽ�ַ���
	 */
	public String getRequestData(){
		return soapRequestData.toString();	
	}
	
	public List<String> getRequestDataList(){
		return	requestData;
	}
	
	/**
	 * @Description ���http�����������Ϣ
	 */
	public void addRequestProperty(String key,String value){
		requestProperty.put(key, value);
	}
	
	/**
	 * @Description ɾ��http�����������Ϣ
	 */
	public void deleteRequestProperty(String key){
		
		for(String k:requestProperty.keySet()){
			if(k.equals(key)){
				requestProperty.remove(key);
			}else System.out.println("RequestProperty��Ҫɾ����keyֵ�����ڣ�");
		}
	}
	
	/**
	 * @Description �����Ѵ��ڵ�http����������Ϣ
	 */
	public void updateRequestProperty(String key,String newValue){
		
		int flag = 0;
		
		for(String k:requestProperty.keySet()){
			if(k.equals(key)){
				requestProperty.put(key, newValue);
				flag++;
			}
			
		if(flag==0){
			System.out.println("RequestProperty��Ҫ���µ�keyֵ�����ڣ�");
		}
		
		}
	}
	
	/**
	 * @Description �����Ѵ��ڵ�����http�������
	 */
	public void clearRequestProperty(){
		requestProperty.clear();
	}
	
	/**
	 * @Description ���http�������
	 */
	public void addRequestData(String data){
		requestData.add(data);
	}
	
	/**
	 * @Description ��dataĿ¼����ΪfileName��Txt�ļ��д洢�������
	 */
	public void addRequestDataFromText(String filepath){
		
		File file=new File(filepath);
		if(file.exists()){
			ParseTxt pt = new ParseTxt(filepath);		
			soapRequestData.append(pt.readByLinesToString());
		}else Log.logError(filepath+"�ļ������ڣ�");
	}
	
	/**
	 * @Description ����http�������
	 */
	public void updateRequestData(String data,String newData){
		
		for(int i=0;i<requestData.size();i++){
			if(requestData.get(i).equals(data)){
				requestData.set(i, newData);	
			}
		}	
	}
	
	/**
	 * @Description ����Ѵ��ڵ�����http�������
	 */
	public void clearRequestData(){
		soapRequestData.delete(0, soapRequestData.length());
	}
	
	/** 
	 *@Description ����get���󣬽���Ӧ�������ַ�����ʽ������responseString.���ý�������״̬����ֵ
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
				
		} catch (Exception ex) {Log.logError("����GET��������쳣��"+ex);}
		
		finally{
			
            try {
                if (br != null) {
                	br.close();
                }
            } catch (Exception ex) {Log.logError("�ر�IO�������쳣��"+ex);}
		}
		
		if(responseString!=""){
			flag = true;
		}
		return flag;	
	}

	/**
	 *@Description ����post���󣬽���Ӧ�������ַ�����ʽ������responseString.���ý�������״̬����ֵ
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
			  
		}catch(Exception ex){Log.logError("����POST��������쳣��"+ex);}
		
		finally{
			
			try {
				if(out!=null){
					out.close();
				}
				
				if(br!=null){
					br.close();
				}
			} catch (Exception ex) {Log.logError("�ر�IO�������쳣��"+ex);}

		}
		
		if(responseString!=""){
			flag = true;
		}
		return flag;
		}
		 
}
