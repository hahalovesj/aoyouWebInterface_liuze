package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.*;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.app.Result.model.GetMessageInfoResult;
import com.aoyou.test.app.request.GetNewMessageInfoRequest;
import com.google.gson.*;

public class GetNewMessageInfo_001 extends TestBase{

	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test
	public void getNewMessageInfo_001(){
		
		this.test=new GetNewMessageInfoRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		System.out.println(this.test.getResponseString());
		int status=this.test.getStatus();
		if(status==200){
			Gson gson=new Gson();
			String responseString=this.test.getResponseString();
			GetMessageInfoResult getMessageInfoResult=gson.fromJson(responseString, GetMessageInfoResult.class);
			if(getMessageInfoResult.ReturnCode==0){
				this.checkPoint.equals(getMessageInfoResult.Message,"��ȡ������Ϣ�б�ɹ�","ִ����Ϣֵ����ȷ,����ֵΪ:["+getMessageInfoResult.Message+"],����ֵΪ:[��ȡ������Ϣ�б�ɹ�]");
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ��!״̬��"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡ������Ϣ�ɹ���");
	}
}
