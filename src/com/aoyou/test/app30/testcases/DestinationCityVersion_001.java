package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.DestinationCityVersionResult;
import com.aoyou.test.app.request.DestinationCityVersionRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class DestinationCityVersion_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void destinationCityVersion_001(){
		
		this.test=new DestinationCityVersionRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		
		if(status==HttpStatus.OK.value()){
			DestinationCityVersionResult result=(DestinationCityVersionResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(result.ReturnCode==0){
				
			}
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码："+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取目的地版本成功");
	}
}
