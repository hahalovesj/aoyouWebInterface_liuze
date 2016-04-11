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
				this.checkPoint.equals(getTicketCityListResult.Message,"��ȡ��Ʊ��Ʒ���гɹ�!","ִ����Ϣֵ����ȷ,����ֵΪ:["+getTicketCityListResult.Message+"],����ֵΪ:[��ȡ��Ʊ��Ʒ���гɹ�!]");
			
				int size =getTicketCityListResult.Data.size();
				if(size>0){
					//�˴������ӽڵ���֤
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿڵ���ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��������Ϊ["+getTicketCityListParam.Key_Word+"]�ĳ����б��ȡ�ɹ���");
	}
}
