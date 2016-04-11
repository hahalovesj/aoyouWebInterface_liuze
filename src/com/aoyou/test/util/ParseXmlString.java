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
 * @Description xml字符串解析模块
 */

public class ParseXmlString {
	
	String xmlString;
	Document document;
	Map<String,String> nameSpace = new HashMap<String,String>();

	/*加载xml字符串，并且产生一个document的对象*/
	public void Load(String xmlString){
		
		if(xmlString.length()!=0){
			
			InputStream in = null; 
			
			try {
				in =new ByteArrayInputStream(xmlString.getBytes("UTF-8"));
				SAXReader sax = new SAXReader();

				if(!nameSpace.isEmpty()){sax.getDocumentFactory().setXPathNamespaceURIs(nameSpace);}
				document = sax.read(in);
				
			}catch (UnsupportedEncodingException e){} 
			 catch (DocumentException ex) {Log.logError("加载xml字符串异常！"+ex);}
			
			finally{
				try {
					if(in!=null){
						in.close();
					}
				} catch (IOException ex){Log.logError("关闭IO流出现异常！"+ex);}
			}
			
		}else{
			Log.logError("待处理的xml字符串为空！");
		}
	}
	
	/*加载xml文件，并且产生一个document的对象*/
	/*2015年10月14日 李忠杰新增*/
	public void Load(File xmlFile) throws FileNotFoundException{
		
		if(xmlFile.exists()){
			
			InputStream in = null; 
			
			try {
				in =new FileInputStream(xmlFile);
				SAXReader sax = new SAXReader();

				if(!nameSpace.isEmpty()){sax.getDocumentFactory().setXPathNamespaceURIs(nameSpace);}
				document = sax.read(in);
				
			}catch (DocumentException ex) {Log.logError("加载xml文件异常！"+ex);}
			
			finally{
				try {
					if(in!=null){
						in.close();
					}
				} catch (IOException ex){Log.logError("关闭IO流出现异常！"+ex);}
			}
			
		}else{
			Log.logError("待处理的文件不存在！");
		}
	}
	
	/**
	 * @Description 获取当前的xml字符串的命名空间信息，返回类型为Map
	 */
	public Map<String,String>getNameSpace(){
		return nameSpace;
	}
	
	/**
	 * @Description 新增命名空间信息
	 * @param key 命名key
	 * @param value URI字符串
	 */
	public void addNameSpace(String key,String value){
		nameSpace.put(key, value);
	}
	
	/**
	 * @Description 删除已存在的命名空间信息
	 */
	public void deleteNameSpace(String key){
		
		for(String k:nameSpace.keySet()){
			if(k.equals(key)){
				nameSpace.remove(key);
			}else System.out.println("nameSpace，要删除的key值不存在！");
		}
	}
	
	/**
	 * @Description 更新已存在的命名空间信息
	 */
	public void updateNameSpace(String key,String newValue){
		
		for(String k:nameSpace.keySet()){
			if(k.equals(key)){
				nameSpace.put(key, newValue);
			}else System.out.println("nameSpace，要更新的key值不存在！");
		}
	}
	
	/**
	 * @Description 清空已存在的命名空间信息
	 */
	public void clearNameSpace(){
		nameSpace.clear();
	}
	
	/**
	 * 用xpath来得到一个元素节点对象
	 * @param elementPath是一个xpath路径，比如"/config/driver"
	 * @return 返回的是一个节点Element对象
	 */
	public Element getElementObject(String elementPath){
		return (Element) document.selectSingleNode(elementPath);
	}
	
	
	/**
	 * 用xpath来判断一个节点对象是否存在
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
	
	/*处理复杂同名多节点下的子节点,比如两个testUI下面是不同的子节点*/
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
		}else {texts = null;Log.logError("xml解析，获取元素失败： "+elementPath);}
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



