package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetActivityHotSaleProductsResult;
import com.aoyou.test.app.request.GetActivityHotSaleProductsRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetActivityHotSaleProducts_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getActivityHotSaleProducts_001(){
		
		this.test=new GetActivityHotSaleProductsRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status =this.test.getStatus();
		
		if(status==HttpStatus.OK.value()){
			GetActivityHotSaleProductsResult getActivityHotSaleProductsResult=(GetActivityHotSaleProductsResult)((RestServiceTemplate)this.test).getResponseMode();
			
			if(getActivityHotSaleProductsResult.ReturnCode==0){
				this.checkPoint.equals(getActivityHotSaleProductsResult.Message, "获取App热门特卖产品数据成功!", "执行消息值不正确,返回值为:["+getActivityHotSaleProductsResult.Message+"],期望值为:[获取App热门特卖产品数据成功!]");
				
				//针对returncode=0 但是没有数据返回的情况
				int size=getActivityHotSaleProductsResult.Data.size();
				if(size>0){
					//此处加入子节点验证
					
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取App热门特卖产品数据成功!");
	}
}
