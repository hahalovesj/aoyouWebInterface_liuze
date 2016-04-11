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
			this.checkPoint.equals(result.Data.TPID,ticketIndexParamModel.TPID , "�ش�����Ʊ�����Ԥ�ڲ�һ�£�����ֵΪ["+result.Data.TPID+"],����ֵΪ["+ticketIndexParamModel.TPID+"]");
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]������["+ticketIndexParamModel.TPID+"]����Ϣ��ȡ�ɹ�");
	}
}
