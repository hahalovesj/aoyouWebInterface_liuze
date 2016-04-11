package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetTicketCityListResult;
import com.aoyou.test.app.request.GetTicketCityListRequest;
import com.aoyou.test.app.request.param.model.GetTicketCityListParamModel;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetTicketCityList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		
	}
	
	@Test
	public void getTicketCityList_001(){
		
		this.test=new GetTicketCityListRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		
		GetTicketCityListParamModel getTicketCityListParam=((RestServiceTemplate) this.test).getRequestParamMode();
		if(status==200){
			GetTicketCityListResult getTicketCityListResult=(GetTicketCityListResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(getTicketCityListResult.ReturnCode==0){
				this.checkPoint.equals(getTicketCityListResult.Message,"获取门票产品城市成功!","执行消息值不正确,返回值为:["+getTicketCityListResult.Message+"],期望值为:[获取门票产品城市成功!]");
			
				int size =getTicketCityListResult.Data.size();
				if(size>0){
					//此处加入子节点验证
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("接口调用失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]搜索条件为["+getTicketCityListParam.Key_Word+"]的城市列表获取成功！");
	}
}
