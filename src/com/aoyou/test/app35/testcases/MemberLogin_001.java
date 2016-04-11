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
				this.checkPoint.equals(memberLoginResult.Data.Mobile, memberLoginParamModel.LoginName, "接口回传登录名与入参不一致，返回值为:["+memberLoginResult.Data.Mobile+"],期望结果为：["+memberLoginParamModel.LoginName+"]");
				RestServiceTemplate.encryString=memberLoginResult.Data.MemberID;
			}
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]账户["+memberLoginParamModel.LoginName+"]登录成功！");
	}	
}
