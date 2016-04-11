package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetIndexRecommendProductResult;
import com.aoyou.test.app.request.GetIndexRecommendProductRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.google.gson.Gson;

public class GetIndexRecommendProduct_001 extends TestBase{

	@BeforeClass 
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getIndexRecommendProduct_001(){
		
		this.test=new GetIndexRecommendProductRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			Gson gson=new Gson();
			String responseString=this.test.getResponseString();
			GetIndexRecommendProductResult getIndexRecommendProductResult=gson.fromJson(responseString, GetIndexRecommendProductResult.class);
			
			if(getIndexRecommendProductResult.ReturnCode==0){
				this.checkPoint.equals(getIndexRecommendProductResult.Message,"获取App首页推荐产品成功","执行消息值不正确,返回值为:["+getIndexRecommendProductResult.Message+"],期望值为:[获取App首页推荐产品成功]");
				
				//针对returncode=0 但是没有数据返回的情况
				int size=getIndexRecommendProductResult.Data.size();
				if(size>0){
					//此处加入子节点验证
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败!状态码"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取首页推荐产品成功");
	}
}
