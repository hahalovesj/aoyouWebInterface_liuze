package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetMemberResult;
import com.aoyou.test.app.request.GetMemberRequest;
import com.aoyou.test.app.request.param.model.GetMemberParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetMember_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getMember_001(){
		
		this.test=new GetMemberRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		GetMemberParamModel GetMemberParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		
		System.out.println(this.test.getResponseString());
		if(status==HttpStatus.OK.value()){
			GetMemberResult getMemberResult=(GetMemberResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(getMemberResult.ReturnCode==0){
				this.checkPoint.equals(getMemberResult.Data.Email, GetMemberParamModel.Email, "�ش���Email����β���������ֵΪ:["+getMemberResult.Data.Email+"],����ֵΪ:["+GetMemberParamModel.Email+"]");
				this.checkPoint.equals(getMemberResult.Data.Mobile, GetMemberParamModel.Mobile, "�ش���Email����β���������ֵΪ:["+getMemberResult.Data.Mobile+"],����ֵΪ:["+GetMemberParamModel.Mobile+"]");
			}
		}else{
			this.checkPoint.isFaild("�ӿڵ���ʧ�ܣ�״̬��Ϊ:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡ�绰����Ϊ["+GetMemberParamModel.Mobile+"]����Ϊ["+GetMemberParamModel.Email+"]�Ļ�Ա��Ϣ�ɹ�");
	}
}
