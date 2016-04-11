package com.aoyou.test.util;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;

import com.aoyou.test.base.Data;


/**
 * @Package com.aoyou.test.util
 * @ClassName Log
 * @Description ��־��ӡģ��.��־����:Info<Warn<Error
 * 3�������ӿڷ���:logError/logInfo/logWarn
 * 
 */
 
public class Log {
	
	private static Logger logger;
	private static String filePath="src/log4j.properties";
	private static boolean flag=false;
	
	private static synchronized void getPropertyFile(){	
		logger=Logger.getLogger("");
		PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
		flag=true;
	}
	
	/**
	 * ��ʼ����飬������״ε������¼����ļ�·��
	 */
	private static void getFlag(){		
		if(flag == false)
			Log.getPropertyFile();
	}
	
	/**
	 * ��ӡInfo�������־
	 * @param message ��Ҫ��ӡ����Ϣ
	 */
	public static void logInfo(String message){
		Log.getFlag();
		logger.info("["+Data.currentClassName+"]"+message);
	}
	
	/**
	 * ��ӡError�������־
	 * @param message ��Ҫ��ӡ����Ϣ
	 */
	public static void logError(String message){
		Log.getFlag();
		logger.error("["+Data.currentClassName+"]"+message);
		reporter(1,message);
	}
	
	/**
	 * ��ӡWarning�������־
	 * @param message ��Ҫ��ӡ����Ϣ
	 */
	public static void logWarn(String message){
		Log.getFlag();
		logger.warn("["+Data.currentClassName+"]"+message);
		reporter(2,message);
	}
	
	public static void reporter(int level,String message){
		switch(level){
		case 0:
			Reporter.log("��PASS��"+" ["+Data.currentClassName+"]"+message);
			Data.reporterLog.add("��PASS��"+" ["+Data.currentClassName+"]"+message);
			break;
		case 1:
			Reporter.log("��FAILED�� "+" ["+Data.currentClassName+"]"+message);
			Data.reporterLog.add("��FAILED�� "+" ["+Data.currentClassName+"]"+message);
			break;	
		case 2:
			Reporter.log("��WARNING�� "+" ["+Data.currentClassName+"]"+message);
			Data.reporterLog.add("��WARNING�� "+" ["+Data.currentClassName+"]"+message);
			break;	
		default:System.out.println("���漶�����!");	
		}
		
	}
	
	
}
