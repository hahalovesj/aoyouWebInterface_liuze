package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.TicketSearchResult;
import com.aoyou.test.app.request.TicketSearchRequest;
import com.aoyou.test.app.request.param.model.SearchParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class TicketSearch_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void ticketSearch_001(){
		
		this.test=new TicketSearchRequest();
		this.test.sendPost();
		
		//System.out.println(this.test.getResponseString());
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		SearchParamModel search=((RestServiceTemplate) this.test).getRequestParamMode();
		TicketSearchResult ticketSearchResult=null;
		if(status==HttpStatus.OK.value()){
			ticketSearchResult=(TicketSearchResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(ticketSearchResult.ReturnCode==0){
				
			}
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码："+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]Key_Word为["+search.Key_Word+"]的景点搜索成功！");
	}
}
