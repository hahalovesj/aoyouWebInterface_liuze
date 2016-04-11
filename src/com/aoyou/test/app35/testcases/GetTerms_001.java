package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetTermsResult;
import com.aoyou.test.app.request.GetTermsRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.google.gson.Gson;

public class GetTerms_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getTerms_001(){
		
		this.test=new GetTermsRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status = this.test.getStatus();
		
		if(status==200){
			Gson gson=new Gson();
			String responseString=this.test.getResponseString();
			GetTermsResult getTermsResult=gson.fromJson(responseString, GetTermsResult.class);
			
			if(getTermsResult.ReturnCode==0){
				this.checkPoint.equals(getTermsResult.Message, "获取指定期数的数据成功", "执行消息值不正确,返回值为:["+getTermsResult.Message+"],期望值为:[获取指定期数的数据成功]");
				
				int size =getTermsResult.Data.size();
				if(size>0){
					//此处加入子节点验证
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败!状态码"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取指定期数的数据成功！");
	}
}
