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
				this.checkPoint.equals(getMemberResult.Data.Email, GetMemberParamModel.Email, "回传的Email与入参不符，返回值为:["+getMemberResult.Data.Email+"],期望值为:["+GetMemberParamModel.Email+"]");
				this.checkPoint.equals(getMemberResult.Data.Mobile, GetMemberParamModel.Mobile, "回传的Email与入参不符，返回值为:["+getMemberResult.Data.Mobile+"],期望值为:["+GetMemberParamModel.Mobile+"]");
			}
		}else{
			this.checkPoint.isFaild("接口调用失败！状态码为:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取电话号码为["+GetMemberParamModel.Mobile+"]邮箱为["+GetMemberParamModel.Email+"]的会员信息成功");
	}
}
