package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.DepartureCityResult;
import com.aoyou.test.app.request.DepartureCityRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;

public class DepartureCity_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void departureCity_001(){
		
		this.test=new DepartureCityRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			DepartureCityResult departureCityResult=(DepartureCityResult)((RestServiceTemplate)this.test).getResponseMode();
			if(departureCityResult.ReturnCode==0){
				this.checkPoint.equals(departureCityResult.Message,"获取App出发地城市信息成功!","执行消息值不正确,返回值为:["+departureCityResult.Message+"],期望值为:[获取App出发地城市信息成功!]");
			}
		}else{
			this.checkPoint.isFaild("接口请求失败!状态码"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取出发地城市列表成功！");
	}
}
