package com.aoyou.test.util;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {
	
	 	private MimeMessage mimeMsg; //MIME�ʼ�����   
	 	private Session session; //�ʼ��Ự����   
	 	private Properties props; //ϵͳ����   
	 //smtp��֤�û���������   
	 	private String username;   
	 	private String password;   
	 	private Multipart mp; //Multipart����,�ʼ�����,����,���������ݾ���ӵ����к�������MimeMessage����   
 
	    /** 
	     * Constructor 
	     * @param smtp �ʼ����ͷ����� 
	     */  
	  	public Mail(String smtp){   
	      setSmtpHost(smtp);   
	      createMimeMessage();   
	  }   
	  
	    /** 
	     * �����ʼ����ͷ����� 
	     * @param hostName String  
	     */  
	  	public void setSmtpHost(String hostName) {   
	  		Log.logInfo("����ϵͳ���ԣ�mail.smtp.host = "+hostName);   
	        if(props == null)  
	            props = System.getProperties(); //���ϵͳ���Զ���    
	        props.put("mail.smtp.host",hostName); //����SMTP����   
	    }   
	  
	  
	    /** 
	     * ����MIME�ʼ�����   
	     * @return 
	     */  
	    public boolean createMimeMessage()   
	    {   
	        try {   
	            Log.logInfo("׼����ȡ�ʼ��Ự����");   
	            session = Session.getDefaultInstance(props,null); //����ʼ��Ự����   
	        }   
	        catch(Exception e){   
	            System.err.println("��ȡ�ʼ��Ự����ʱ��������"+e);   
	            return false;   
	        }   
	      
	        Log.logInfo("׼������MIME�ʼ�����");   
	        try {   
	            mimeMsg = new MimeMessage(session); //����MIME�ʼ�����   
	            mp = new MimeMultipart("related");   
	          
	            return true;   
	        } catch(Exception e){   
	            System.err.println("����MIME�ʼ�����ʧ�ܣ�"+e);   
	            return false;   
	        }   
	    }     
	      
	    /** 
	     * ����SMTP�Ƿ���Ҫ��֤ 
	     * @param need 
	     */  
	    public void setNeedAuth(boolean need) {   
	    	Log.logInfo("����smtp�����֤��mail.smtp.auth = "+need);   
	        if(props == null) props = System.getProperties();   
	        if(need){   
	            props.put("mail.smtp.auth","true");   
	        }else{   
	            props.put("mail.smtp.auth","false");   
	        }   
	    }   
	  
	    /** 
	     * �����û��������� 
	     * @param name 
	     * @param pass 
	     */  
	    public void setNamePass(String name,String pass) {   
	        username = name;   
	        password = pass;   
	    }   
	  
	    /** 
	     * �����ʼ����� 
	     * @param mailSubject 
	     * @return 
	     */  
	    public boolean setSubject(String mailSubject) {   
	    	Log.logInfo("�����ʼ����⣡");   
	        try{   
	            mimeMsg.setSubject(mailSubject);   
	            return true;   
	        }   
	        catch(Exception e) {   
	            System.err.println("�����ʼ����ⷢ������");   
	            return false;   
	        }   
	    }  
	      
	    /**  
	     * �����ʼ����� 
	     * @param mailBody String  
	     */   
	    public boolean setBody(String mailBody) {   
	        try{   
	        	  
//	            String htmlText = "<H1>Results overview</H1><img src=\"cid:image\">";
	        	MimeBodyPart textBody = new MimeBodyPart();                
	            textBody.setContent(mailBody, "text/html;charset=gb2312");           
	            mp.addBodyPart(textBody);
//	            bp.setHeader("Content-ID","<image>");
	            
//	            bp.setContent("<h1>Results overview</h1>"+"<img src=\"D:/ReportResult.bmp\">","text/html");
//	            bp.setContent("<h1>Reporter output</h1>"+"<img src=\"D:/ReportOutput.bmp\">","text/html");  

	            return true;   
	        } catch(Exception e){   
	        System.err.println("�����ʼ�����ʱ��������"+e);   
	        return false;   
	        }   
	    }   
	    /**  
	     * ��Ӹ��� 
	     * @param filename String  
	     */   
	    public boolean addFileAffix(String filename) {   
	      
	    	Log.logInfo("�����ʼ�������"+filename);   
	        try{   
	            BodyPart bp = new MimeBodyPart();   
	            FileDataSource fileds = new FileDataSource(filename);   
	            bp.setDataHandler(new DataHandler(fileds));   
	            bp.setFileName(fileds.getName());   
	            mp.addBodyPart(bp);   
	              
	            return true;   
	        } catch(Exception e){   
	            System.err.println("�����ʼ�������"+filename+"��������"+e);   
	            return false;   
	        }   
	    }   
	      
	    /**  
	     * ���÷����� 
	     * @param from String  
	     */   
	    public boolean setFrom(String from) {   
	    	Log.logInfo("���÷����ˣ�");   
	        try{   
	            mimeMsg.setFrom(new InternetAddress(from, "�������Զ�������")); //���÷�����   
	            return true;   
	        } catch(Exception e) {   
	            return false;   
	        }   
	    }   
	    /**  
	     * ���������� 
	     * @param to String  
	     */   
	    public boolean setTo(String to){   
	        if(to == null)return false;   
	        try{   
	            mimeMsg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));   
	            return true;   
	        } catch(Exception e) {   
	            return false;   
	        }     
	    }   
	      
	    /**  
	     * ���ó����� 
	     * @param copyto String   
	     */   
	    public boolean setCopyTo(String copyto)   
	    {   
	        if(copyto == null)return false;   
	        try{   
	        mimeMsg.setRecipients(Message.RecipientType.CC,(Address[])InternetAddress.parse(copyto));   
	        return true;   
	        }   
	        catch(Exception e)   
	        { return false; }   
	    }   
	      
	    /**  
	     * �����ʼ� 
	     * @throws MessagingException 
	     */   
		public boolean sendOut(boolean needCopyto)   
	    {   
	        try{   
	            mimeMsg.setContent(mp);   
	            mimeMsg.saveChanges();   
	            Log.logInfo("���ڷ����ʼ�....");   
	              
	            Session mailSession = Session.getInstance(props,null);   
	            Transport transport = mailSession.getTransport("smtp");   
	            transport.connect((String)props.get("mail.smtp.host"),username,password);   
	            transport.sendMessage(mimeMsg,mimeMsg.getRecipients(Message.RecipientType.TO));  
	            if(needCopyto){
	            	transport.sendMessage(mimeMsg,mimeMsg.getRecipients(Message.RecipientType.CC));  
	            }
//	            transport.send(mimeMsg);   
	              
	            Log.logInfo("�����ʼ��ɹ���");   
	            transport.close();   
	              
	            return true;   
	        } catch(Exception e) {   
	            System.err.println("�ʼ�����ʧ�ܣ�"+e);   
	            return false;   
	        }   
	    }   
	        
	    /** 
	     * ����sendOut��������ʼ�����
	     * @param smtp 
	     * @param from 
	     * @param to 
	     * @param copyto 
	     * @param subject 
	     * @param content 
	     * @param username 
	     * @param password 
	     * @param filename 
	     * @return 
	     * @throws MessagingException 
	     */  
	    public static boolean send(String content){  
	        Mail theMail = new Mail(Config.SMTPserver);  
	        theMail.setNeedAuth(true); //��Ҫ��֤  
	        boolean needCopyto = true;
	        if(!theMail.setSubject(Config.subject)) return false;  
	        if(!theMail.setBody(content)) return false;  
	        
	        if(!Config.filename.equals("")){
	        	if(!theMail.addFileAffix(Config.filename)) return false;   
	        }
	        
	        if(!theMail.setTo(Config.to)) return false; 
	        
	        if(Config.copyTo.equals("")||Config.copyTo.equals(" ")){
	        	needCopyto = false;	        	
	        }else{
	        	if(!theMail.setCopyTo(Config.copyTo)) return false; 
	        }
	        
	        if(!theMail.setFrom(Config.from)) return false;  
	        theMail.setNamePass(Config.username,Config.password);  
	        if(!theMail.sendOut(needCopyto)) return false;  
	        return true;  
	    }  
}
