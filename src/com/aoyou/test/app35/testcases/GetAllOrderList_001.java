package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aoyou.test.app.Result.model.GetAllOrderListResult;
import com.aoyou.test.app.request.GetAllOrderListRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetAllOrderList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getAllOrderListModel(){
		
		this.test=new GetAllOrderListRequest();
		this.test.sendPost();
		
		//GetAllOrderListParamModel getMemberMainDataParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		//System.out.println(this.test.getResponseString());
		if(status==HttpStatus.OK.value()){
			GetAllOrderListResult getAllOrderListResult=(GetAllOrderListResult) ((RestServiceTemplate) this.test).getResponseMode();
			switch(getAllOrderListResult.ReturnCode){
			case 0: break;
			case -1: this.checkPoint.equals(getAllOrderListResult.Message, "��û�ж����б�", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getAllOrderListResult.Message+"],����ֵΪ:[��û�ж����б�]");break;
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡ��Ա�����б�ɹ�");
	}
}
