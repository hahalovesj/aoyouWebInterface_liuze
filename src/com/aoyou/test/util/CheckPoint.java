package com.aoyou.test.util;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;

/**
* @Package com.aoyou.test.util
* @ClassName CheckPoint 
* @Description ����ģ��
* 
* 7�������ӿڷ�����equals/notEquals/startWith/contains/result/isFaild/isSuccess
* 
*/

public class CheckPoint {
	
	private int flag;

	/**
	 * ʵ����ScreenShot����
	 * ��ʼ�� ��־λ
	 */
	public CheckPoint(){
		flag=0;		
	}
	
	/**
	* @Description ��ֵ�Աȣ�false�����־λ+1
	* @param message:ֵ�����ʱ����Ҫ��¼����־�Ĵ�������
	*/
	public void equals(Object actual,Object expected,String message){
		try{
			Assert.assertEquals(actual, expected);
		}catch(Error e){
			flag=flag+1;
			Log.logError(message);
		}
	}

	public void equals(boolean actual,boolean expected,String message){
		try{
			Assert.assertEquals(actual, expected);
		}catch(Error e){
			flag=flag+1;
			Log.logError(message);			
		}
	}
	
	public void equals(boolean actual,boolean expected){
		try{
			Assert.assertEquals(actual, expected);
		}catch(Error e){
			flag=flag+1;
		}
	}
		
	public void equals(String actual,String expected,String message){
		try{
			Assert.assertEquals(actual, expected);

		}catch(Error e){
			flag=flag+1;
			Log.logError(message);
		}		
	}
	
	public void equals(int actual,int expected,String message){
		try{
			Assert.assertEquals(actual, expected);
		}catch(Error e){
			flag=flag+1;
			Log.logError(message);			
		}				
	}
	
	public void equals(int actual,int expected){
		try{
			Assert.assertEquals(actual, expected);
		}catch(Error e){
			flag=flag+1;			
		}				
	}
	
	public void equals(List<String> actual,String expected,String message){
		
		if(actual.size()!=0){
			for(String s:actual){
				if 	(!s.equals(expected)){
					Log.logError(message+" :"+s);
					flag=flag+1;
				}
			}
		}else this.isFaild("List����Ϊ�գ�");		
	}
	
     public void equals(List<String> actual,List<String> expected,String message){
    	 
    	 if(actual.size()!=0){
    	 if(!actual.equals(expected)){
    		 Log.logError(message);
    		 flag=flag+1;
    	 }
		
		}else this.isFaild("List����Ϊ�գ�");	
	
}
	
	/**
	* @Description ����ֵ�Աȣ�false�����־λ+1
	* @param message:ֵ�����ʱ����Ҫ��¼����־�Ĵ�������
	*/
	public void notEquals(String actual,String expected,String message){
		
		if 	(actual.equals(expected)){
			Log.logError(message);
			flag=flag+1;
		}	
		
	}
	
    public void notEqual(String actual,String expected){
		
		if 	(actual.equals(expected)){
			this.isFaild("�쳣������ֵ��ʵ��ֵ��ȣ�");
			flag=flag+1;
		}	
		
	}
	
	public void notEquals(int actual,int expected,String message){
		
		if 	(actual == expected){
			Log.logError(message);
			flag=flag+1;
		}	
		
	}
	
	public void notEquals(String[]actual,String expected){
		if(actual.length!=0){	
			for(int i=0;i<actual.length;i++){				
				this.notEquals(actual[i], expected, actual[i]+"�쳣��");
			}
		}else this.isFaild("�������Ϊ�գ�");
	}
						
	public void notEquals(ArrayList<String>actual,String expected){
		if(actual.size()!=0){
			for(int i=0;i<actual.size();i++){			
				this.notEquals(actual.get(i), expected, actual.get(i)+"�쳣��");
			}
		}else this.isFaild("�������Ϊ�գ�");
	}
	
	public void notEquals(List<String>actual,String expected){
		if(actual.size()!=0){
			for(int i=0;i<actual.size();i++){			
				this.notEquals(actual.get(i), expected, actual.get(i)+"�쳣��");
			}
		}else this.isFaild("�������Ϊ�գ�");
	}

	
	/** 
	* @Description �ж�actual�ַ����Ƿ���������expected��ʼ��false�����־λ+1
	*/
	public void startWith(String actual,String expected,String message){
		
		if (!actual.startsWith(expected)){			
			Log.logError(message);
			flag=flag+1;
		}			
	}
	
	public void startWith(String[] actual,String expected){
		
		for(String act : actual )			
			if (!act.startsWith(expected)){				
				Log.logError(act+"�쳣��");
				flag=flag+1;
			}			
	}
	
	public void startWith(String[] actual,String[] expected){
		
		if (actual.length==expected.length){			
			for(int i=0;i<actual.length;i++){				
				if (!actual[i].startsWith(expected[i])){	
					Log.logError("�쳣��"+actual[i]+expected[i]);
					flag=flag+1;
					}	
			}	
		}else{
			Log.logError("���鳤�Ȳ��ȣ����ҳ����������");
		}
	}
	
	/**
	* @Description �ж�actual�ַ��������е�ÿһ��ֵ���Ƿ񶼰���expected�ַ� ��false�����־λ+1
	*/
	public void contains(String[] actual,String expected,String message){
		if(actual.length!=0){
		for(String act : actual )			
			if (!act.contains(expected)){			
				Log.logError(" "+message+" ���쳣��"+act);
				flag=flag+1;
			}
		}else this.isFaild("�������Ϊ�գ�");
	}
	
	public void contains(String[] actual,String expected1,String expected2,String message ){
		if(actual.length!=0){
		for(String act : actual )			
			if (!act.contains(expected1) && !act.contains(expected2) ){			
				Log.logError(" "+message+" ���쳣��"+act);
				flag=flag+1;
			}
		}else this.isFaild("�������Ϊ�գ�");
	}
	
	public void contains(List<String> actual,String expected,String message){
		if(actual.size()!=0){
		for(String act : actual )			
			if (!act.contains(expected)){			
				Log.logError(" "+message+" ���쳣��"+act);
				flag=flag+1;
			}
		}else this.isFaild("List����Ϊ�գ�");
	}
	
	/**
	* @Description �ж�actual�ַ����Ƿ񶼰���expected�ַ� ��false�����־λ+1
	*/
	public void contains(String actual,String expected,String message){
				
			if (!actual.contains(expected)){			
				Log.logError(message);
				flag=flag+1;
			}
		}
	
	/**
	* @Description ��case����Ҫ�õ�if�������������ʱʹ�øü���
	* @param message������ʱ��Ҫ��¼����־����Ϣ
	*/
	public void isFaild(String message){
		this.equals(true, false, message);
	}
	
	/**
	* @Description ��case����Ҫ�õ�if���������passʱǿ��ʹ�øü���
	* @param message��passʱ��Ҫ��¼����־����Ϣ
	*/
	public void isSuccess(String message){
		this.equals(true, true, message);
	}
	
	/**
	* @Description ����flag���жϴ�ǰ���м������Ƿ��д���ֵ����ʧ�ܣ��˳���ǰ���е�.java����
	* 			      ʧ�ܺ�result�����·��Ĵ��뽫���ᱻִ��
	* @param message:case�ɹ�ʱ��Ҫ��¼����־����Ϣ
	*/
	public void result(String message){	
		Assert.assertEquals(flag, 0);
		Log.logInfo(message);
		Log.reporter(0, message);
	}
	
}
