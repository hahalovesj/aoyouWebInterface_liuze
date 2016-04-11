package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetPopularSearchListResult;
import com.aoyou.test.app.request.GetPopularSearchListRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetPopularSearchList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getPopularSearchList_001(){
		
		this.test=new GetPopularSearchListRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
			
		if(status==HttpStatus.OK.value()){
			GetPopularSearchListResult getPopularSearchListResult=(GetPopularSearchListResult) ((RestServiceTemplate)this.test).getResponseMode();
			if(getPopularSearchListResult.ReturnCode==0){
				this.checkPoint.equals(getPopularSearchListResult.Message, "热门标签获取成功!", "执行消息值不正确,返回值为:["+getPopularSearchListResult.Message+"],期望值为:[热门标签获取成功!]");
				
				int size =getPopularSearchListResult.Data.size();
				if(size>0){
					//此处加入子节点验证
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败!状态码为:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]热门标签获取成功!");
	}
}
