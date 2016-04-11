package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.TestBase;
import com.aoyou.test.base.Data;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.app.request.*;
import com.aoyou.test.app.request.param.model.AddMessageHitsParamModel;
import com.aoyou.test.app.Result.model.AddMessageHitsResult;

public class AddMessageHits_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	
	@Test
	public void addMessageHits(){
		
		this.test=new AddMessageHitsRequest();
		this.test.sendPost();
		//System.out.println(this.test.getResponseString());
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			//Gson gson=new Gson();
			//String responseString=this.test.getResponseString();
			AddMessageHitsResult addMessageHitsResult=(AddMessageHitsResult)((RestServiceTemplate)this.test).getResponseMode();
			this.checkPoint.equals(addMessageHitsResult.Message, "��Ϣ�����ͳ�Ƴɹ�", "ִ����Ϣֵ����ȷ,����ֵΪ:["+addMessageHitsResult.Message+"],����ֵΪ:[��Ϣ�����ͳ�Ƴɹ�]");
			this.checkPoint.equals(addMessageHitsResult.ReturnCode, 0, "ִ����Ϣ���벻��ȷ,����ֵΪ:["+addMessageHitsResult.ReturnCode+"],����ֵΪ:[0]");
			this.checkPoint.equals(addMessageHitsResult.Data, true, "ִ�н������ȷ,����ֵΪ :["+addMessageHitsResult.Data+"],����ֵΪ:[true]");
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ��!״̬��"+status);
		}
		AddMessageHitsParamModel addMessageHitsParamModel=((RestServiceTemplate)this.test).getRequestParamMode();
		checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ϢID:["+addMessageHitsParamModel.ProMoID+"]��Ϣ����:["+addMessageHitsParamModel.ProType+"]����������ɹ���");
	}
}
