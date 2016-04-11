package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetVisaInfoResult;
import com.aoyou.test.app.request.GetVisaInfoRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetVisaInfo_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getVisaInfo_001(){
		
		this.test=new GetVisaInfoRequest();
		this.test.sendPost();
		
		//System.out.println(this.test.getResponseString());
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		
		if(status==HttpStatus.OK.value()){
			GetVisaInfoResult result=(GetVisaInfoResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(result.ReturnCode==0){
				
			}
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取签证说明详细信息");
	}
}
