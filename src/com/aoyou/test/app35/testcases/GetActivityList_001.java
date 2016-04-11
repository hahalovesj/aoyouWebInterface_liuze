package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aoyou.test.app.Result.model.GetActivityListResult;
import com.aoyou.test.app.request.GetActivityListRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetActivityList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getActivityList_001(){
		
		this.test=new GetActivityListRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			GetActivityListResult getActivityListResult=(GetActivityListResult)((RestServiceTemplate)this.test).getResponseMode();
			
			if(getActivityListResult.ReturnCode==0){
				this.checkPoint.equals(getActivityListResult.Message, "获取App首页Banner活动列表成功!", "执行消息值不正确,返回值为:["+getActivityListResult.Message+"],期望值为:[获取App首页Banner活动列表成功!]");
			}
			
			int size =getActivityListResult.Data.size();
			if(size>0){
				//此处加入子节点验证
			}else{
				
			}
		}else{
			this.checkPoint.isFaild("接口请求失败!状态码"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取App首页Banner活动列表成功!");
	}
}
