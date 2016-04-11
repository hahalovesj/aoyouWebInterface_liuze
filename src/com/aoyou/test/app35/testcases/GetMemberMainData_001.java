package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.request.GetMemberMainDataRequest;
import com.aoyou.test.app.request.param.model.GetMemberMainDataParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetMemberMainData_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getMemberMainData_001(){
		
		this.test=new GetMemberMainDataRequest();
		this.test.sendPost();
		GetMemberMainDataParamModel getMemberMainDataParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		//System.out.println(this.test.getResponseString());
		if(status==HttpStatus.OK.value()){
			
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取手机号为["+getMemberMainDataParamModel.mobile+"]的主页信息成功");
	}
}
