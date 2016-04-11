package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetActivityDepartCityListResult;
import com.aoyou.test.app.request.GetActivityDepartCityListRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetActivityDepartCityList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getActivityDepartCityList_001(){
		
		this.test=new GetActivityDepartCityListRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==HttpStatus.OK.value()){
			GetActivityDepartCityListResult getActivityDepartCityListResult=(GetActivityDepartCityListResult)((RestServiceTemplate) this.test).getResponseMode();
			if(getActivityDepartCityListResult.ReturnCode==0){
				this.checkPoint.equals(getActivityDepartCityListResult.Message, "获取抢优惠筛选出发地数据成功!", "执行消息值不正确,返回值为:["+getActivityDepartCityListResult.Message+"],期望值为:[获取抢优惠筛选出发地数据成功!]");
				
				int size =getActivityDepartCityListResult.Data.size();
				if(size>0){
					//此处加入子节点验证
				}else{
					
				}
			}else{
				this.checkPoint.isFaild("接口调用失败！状态码："+status);
			}
			
			this.checkPoint.result("[执行时间:"+runTime+"ms]获取抢优惠筛选出发地数据成功!");
		}
	}
}
