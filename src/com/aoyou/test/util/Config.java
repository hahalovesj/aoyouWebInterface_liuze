package com.aoyou.test.util;


/**
 * @Package com.aoyou.test.util
 * @ClassName Config
 * @Description ȫ�����ã�ֵ�־û�ģ��.��ÿ��buildǰ����config.xml,����������Ϣ.��ֹ�ڲ����������޸����ò�����Ӱ��
 * 
 *  browser:�����������������������(chrome/firefox/ie)
 *  browserWaitTime:��������ص���ȴ�ʱ�䣬��λΪs
 *  objectWaitTime��������ҵ���ȴ�ʱ�䣬��λΪs
 *  pageWaitTime��ҳ�������ɵ���ȴ�ʱ�䣬��λΪs
 *  siteName���������е�Ĭ�ϳ���վ��
 *  objectRespository����������������ҳ������·��
 * 
 */

public class Config {
	
	public static int retryTimes;
	public static String SMTPserver;
	public static String from;
	public static String username;
	public static String password ;
	public static String to;
	public static String copyTo;
	public static String filename;
	public static String subject;
	public static String reportAddress;
	public static String projectName;
	
	static{		
		ParseXml pxConfig=new ParseXml("config/config.xml");
		retryTimes=Integer.valueOf(pxConfig.getElementText("/config/retryTimes"));
		SMTPserver=pxConfig.getElementText("/config/mail/SMTPserver");
		from=pxConfig.getElementText("/config/mail/from");
		username=pxConfig.getElementText("/config/mail/username");
		password=pxConfig.getElementText("/config/mail/password");
		to=pxConfig.getElementText("/config/mail/to");
		copyTo=pxConfig.getElementText("/config/mail/copyTo");
		filename=pxConfig.getElementText("/config/mail/filename");
		subject=pxConfig.getElementText("/config/mail/subject"); 
		reportAddress=pxConfig.getElementText("/config/mail/reportAddress"); 
		projectName=pxConfig.getElementText("/config/mail/projectName"); 
	}
	
}


