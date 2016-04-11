package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetVisaCountryListResult;
import com.aoyou.test.app.request.GetVisaCountryListRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetVisaCountryList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getVisaCountryList_001(){
		
		this.test=new GetVisaCountryListRequest();
		this.test.sendPost();
		
		System.out.println(this.test.getResponseString());
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		GetVisaCountryListResult result=null;
		if(status==HttpStatus.OK.value()){
			result=(GetVisaCountryListResult) ((RestServiceTemplate) this.test).getResponseMode();
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取签证国家或地区列表成功，共获取国家和地区["+result.Data.size()+"]个");
	}
}
