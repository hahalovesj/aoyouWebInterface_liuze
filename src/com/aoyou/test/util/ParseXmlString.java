package com.aoyou.test.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


/**
 * @Package com.aoyou.test.util
 * @ClassName ParseXml
 * @Description xml�ַ�������ģ��
 */

public class ParseXmlString {
	
	String xmlString;
	Document document;
	Map<String,String> nameSpace = new HashMap<String,String>();

	/*����xml�ַ��������Ҳ���һ��document�Ķ���*/
	public void Load(String xmlString){
		
		if(xmlString.length()!=0){
			
			InputStream in = null; 
			
			try {
				in =new ByteArrayInputStream(xmlString.getBytes("UTF-8"));
				SAXReader sax = new SAXReader();

				if(!nameSpace.isEmpty()){sax.getDocumentFactory().setXPathNamespaceURIs(nameSpace);}
				document = sax.read(in);
				
			}catch (UnsupportedEncodingException e){} 
			 catch (DocumentException ex) {Log.logError("����xml�ַ����쳣��"+ex);}
			
			finally{
				try {
					if(in!=null){
						in.close();
					}
				} catch (IOException ex){Log.logError("�ر�IO�������쳣��"+ex);}
			}
			
		}else{
			Log.logError("�������xml�ַ���Ϊ�գ�");
		}
	}
	
	/*����xml�ļ������Ҳ���һ��document�Ķ���*/
	/*2015��10��14�� ���ҽ�����*/
	public void Load(File xmlFile) throws FileNotFoundException{
		
		if(xmlFile.exists()){
			
			InputStream in = null; 
			
			try {
				in =new FileInputStream(xmlFile);
				SAXReader sax = new SAXReader();

				if(!nameSpace.isEmpty()){sax.getDocumentFactory().setXPathNamespaceURIs(nameSpace);}
				document = sax.read(in);
				
			}catch (DocumentException ex) {Log.logError("����xml�ļ��쳣��"+ex);}
			
			finally{
				try {
					if(in!=null){
						in.close();
					}
				} catch (IOException ex){Log.logError("�ر�IO�������쳣��"+ex);}
			}
			
		}else{
			Log.logError("��������ļ������ڣ�");
		}
	}
	
	/**
	 * @Description ��ȡ��ǰ��xml�ַ����������ռ���Ϣ����������ΪMap
	 */
	public Map<String,String>getNameSpace(){
		return nameSpace;
	}
	
	/**
	 * @Description ���������ռ���Ϣ
	 * @param key ����key
	 * @param value URI�ַ���
	 */
	public void addNameSpace(String key,String value){
		nameSpace.put(key, value);
	}
	
	/**
	 * @Description ɾ���Ѵ��ڵ������ռ���Ϣ
	 */
	public void deleteNameSpace(String key){
		
		for(String k:nameSpace.keySet()){
			if(k.equals(key)){
				nameSpace.remove(key);
			}else System.out.println("nameSpace��Ҫɾ����keyֵ�����ڣ�");
		}
	}
	
	/**
	 * @Description �����Ѵ��ڵ������ռ���Ϣ
	 */
	public void updateNameSpace(String key,String newValue){
		
		for(String k:nameSpace.keySet()){
			if(k.equals(key)){
				nameSpace.put(key, newValue);
			}else System.out.println("nameSpace��Ҫ���µ�keyֵ�����ڣ�");
		}
	}
	
	/**
	 * @Description ����Ѵ��ڵ������ռ���Ϣ
	 */
	public void clearNameSpace(){
		nameSpace.clear();
	}
	
	/**
	 * ��xpath���õ�һ��Ԫ�ؽڵ����
	 * @param elementPath��һ��xpath·��������"/config/driver"
	 * @return ���ص���һ���ڵ�Element����
	 */
	public Element getElementObject(String elementPath){
		return (Element) document.selectSingleNode(elementPath);
	}
	
	
	/**
	 * ��xpath���ж�һ���ڵ�����Ƿ����
	*/
	public boolean isExist(String elementPath){
		boolean flag=false;
		Element element = this.getElementObject(elementPath);
		if(element!=null)
			flag=true;
		return flag;
	}

	
	public String setElementText(String elementPath,String text)
	{
		Element element=this.getElementObject(elementPath);
		if(element!=null){
			element.setText(text);
			return xmlString;
		}
		else 
			return null;
	}
	
	public String getElementText(String elementPath)
	{
		Element element=this.getElementObject(elementPath);
		if(element!=null){
			return element.getTextTrim();
		}
		else 
			return null;
	}
	
	/*������ͬ����ڵ��µ��ӽڵ�,��������testUI�����ǲ�ͬ���ӽڵ�*/
	@SuppressWarnings("unchecked")
	public List<Element> getElementObjects(String elementPath){
		return document.selectNodes(elementPath);
	}
	
	public List<String> getElementsText(String elementPath){
		
		List<Element> elements = this.getElementObjects(elementPath);
		List<String> texts = new ArrayList<String>();
		
		if(elements.size()!=0){	
			for(Element e:elements){
				texts.add(e.getTextTrim());
			}
		}else {texts = null;Log.logError("xml��������ȡԪ��ʧ�ܣ� "+elementPath);}
		return texts;
	}
	
	public Map<String,String> getChildrenInfo(String elementPath,String key,String key2){
		List<Element> elements = this.getElementObjects(elementPath);
		Map<String,String> map = new LinkedHashMap<String,String>();

		for(Element e : elements){
			map.put(e.element(key).getTextTrim(), e.element(key2).getTextTrim());
		}
		return map;
	}
	
	public Map<String,String> getChildrenInfo(Element element){
		@SuppressWarnings("unchecked")
		List<Element> childrens = element.elements();
		Map<String,String> map = new LinkedHashMap<String,String>();
		
		for(Element e:childrens){
			map.put(e.getName(), e.getTextTrim());
		}
		return map;	
	}

	public Map<String,String> getChildrenInfo(String elementPath){

		@SuppressWarnings("unchecked")
		List<Element> elements = this.getElementObject(elementPath).elements();
		Map<String,String> map = new LinkedHashMap<String,String>();
		
		for(Element e:elements){
			map.put(e.getName(), e.getTextTrim());
		}
		return map;	
	}

}



