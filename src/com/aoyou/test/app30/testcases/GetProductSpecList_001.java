package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetProductSpecListResult;
import com.aoyou.test.app.request.GetProductSpecListRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetProductSpecList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getProductSpecList_001(){
		
		this.test=new GetProductSpecListRequest();
		this.test.sendPost();
		
		System.out.println(this.test.getResponseString());
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		
		if(status==HttpStatus.OK.value()){
			GetProductSpecListResult getProductSpecListResult=(GetProductSpecListResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(getProductSpecListResult.ReturnCode==0){
				
			}
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码："+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取推荐好玩、限时优惠产品成功");
	}
}
