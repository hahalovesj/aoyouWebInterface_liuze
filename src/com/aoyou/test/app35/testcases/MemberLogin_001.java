package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.MemberLoginResult;
import com.aoyou.test.app.request.MemberLoginRequest;
import com.aoyou.test.app.request.param.model.MemberLoginParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class MemberLogin_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void memberLogin_001(){
		
		this.test=new MemberLoginRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		MemberLoginParamModel memberLoginParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		int status=this.test.getStatus();
		
		if(status==HttpStatus.OK.value()){
			MemberLoginResult memberLoginResult=(MemberLoginResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(memberLoginResult.ReturnCode==0){
				this.checkPoint.equals(memberLoginResult.Data.Mobile, memberLoginParamModel.LoginName, "�ӿڻش���¼������β�һ�£�����ֵΪ:["+memberLoginResult.Data.Mobile+"],�������Ϊ��["+memberLoginParamModel.LoginName+"]");
				RestServiceTemplate.encryString=memberLoginResult.Data.MemberID;
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]�˻�["+memberLoginParamModel.LoginName+"]��¼�ɹ���");
	}	
}
