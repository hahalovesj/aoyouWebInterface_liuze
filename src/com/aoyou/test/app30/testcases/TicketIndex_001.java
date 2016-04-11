package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.TicketIndexResult;
import com.aoyou.test.app.request.TicketIndexRequest;
import com.aoyou.test.app.request.param.model.TicketIndexParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class TicketIndex_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void ticketIndex_001(){
		
		this.test=new TicketIndexRequest();
		this.test.sendPost();
		
		//System.out.println(this.test.getResponseString());	
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		TicketIndexParamModel ticketIndexParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		if(status==HttpStatus.OK.value()){
			TicketIndexResult result=(TicketIndexResult) ((RestServiceTemplate) this.test).getResponseMode();
			this.checkPoint.equals(result.Data.TPID,ticketIndexParamModel.TPID , "回传的门票编号与预期不一致，返回值为["+result.Data.TPID+"],期望值为["+ticketIndexParamModel.TPID+"]");
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]景点编号["+ticketIndexParamModel.TPID+"]的信息获取成功");
	}
}
