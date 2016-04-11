package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.MessageIsShowRedPointResult;
import com.aoyou.test.app.request.MessageIsShowRedPointRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.google.gson.Gson;

public class MessageIsShowRedPoint_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void messageIsShowRedPoint_001(){
		
		this.test=new MessageIsShowRedPointRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			Gson gson=new Gson();
			String responseString=this.test.getResponseString();
			MessageIsShowRedPointResult messageIsShowRedPointResult=gson.fromJson(responseString, MessageIsShowRedPointResult.class);
			
			if(messageIsShowRedPointResult.ReturnCode==0){
				this.checkPoint.equals(messageIsShowRedPointResult.Message, "��ȡ�Ƿ���ʾ���ɹ�", "ִ����Ϣֵ����ȷ,����ֵΪ:["+messageIsShowRedPointResult.Message+"],����ֵΪ:[��ȡ�Ƿ���ʾ���ɹ�]");
			}else{
				this.checkPoint.equals(messageIsShowRedPointResult.Message, "��ȡ�Ƿ���ʾ���ʧ��", "ִ����Ϣֵ����ȷ,����ֵΪ:["+messageIsShowRedPointResult.Message+"],����ֵΪ:[��ȡ�Ƿ���ʾ���ʧ��]");
				this.checkPoint.equals(messageIsShowRedPointResult.Data.IsShowRedPoint,false,"�Ƿ���ʾ�������֤ʧ�ܣ�����ֵΪ:["+messageIsShowRedPointResult.Data.IsShowRedPoint+"],����ֵΪ��[false]");
			}	
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ��!״̬��"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡ�Ƿ���ʾ���ɹ�");
	}
}
