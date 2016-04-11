package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.*;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.app.Result.model.UpdateMessageStatusResult;
import com.aoyou.test.app.request.UpdateMessageStatusRequest;
import com.google.gson.*;
import com.aoyou.test.app.request.param.model.UpdateMessageStatusParamModel;

public class UpdateMessageStatus_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void updateMessageStatus_001(){
		
		this.test=new UpdateMessageStatusRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			String responseString=this.test.getResponseString();
			Gson gson=new Gson();
			UpdateMessageStatusResult updateMessageStatusResult=gson.fromJson(responseString, UpdateMessageStatusResult.class);
			if(updateMessageStatusResult.ReturnCode==0){
				this.checkPoint.equals(updateMessageStatusResult.Message, "��Ϣ״̬��д�ɹ�", "ִ����Ϣֵ����ȷ,����ֵΪ:["+updateMessageStatusResult.Message+"],����ֵΪ:[��Ϣ״̬��д�ɹ�]");
				this.checkPoint.equals(updateMessageStatusResult.Data, true, "ִ�н������ȷ,����ֵΪ :["+updateMessageStatusResult.Data+"],����ֵΪ:[true]");
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ��!״̬��"+status);
		}
		
		UpdateMessageStatusParamModel updateMessageStatusParamModel=((RestServiceTemplate)this.test).getRequestParamMode();
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ϢID:["+updateMessageStatusParamModel.MessageId+"]����״̬�ɹ���");
	}
}
