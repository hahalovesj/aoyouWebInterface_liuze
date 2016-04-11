package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetActivityProductListResult;
import com.aoyou.test.app.request.GetActivityProductListRequest;
import com.aoyou.test.app.request.param.model.GetActivityProductListParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetActivityProductList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getActivityProductList_001(){
		
		this.test=new GetActivityProductListRequest();
		this.test.sendPost();	
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		GetActivityProductListParamModel getActivityProductListParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		
		if(status==HttpStatus.OK.value()){
			GetActivityProductListResult getActivityProductListResult=(GetActivityProductListResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(getActivityProductListResult.ReturnCode==0){
				this.checkPoint.equals(getActivityProductListResult.Message, "��ȡ���λݲ�Ʒ�б�ɹ�!", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getActivityProductListResult.Message+"],����ֵΪ:[��ȡ���λݲ�Ʒ�б�ɹ�!]");
				
				//��֤�ڵ�������
				
			}
		}else{
			this.checkPoint.isFaild("�ӿڵ���ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]cityid["+getActivityProductListParamModel.cityid+"]destcityid["+getActivityProductListParamModel.destcityid+"]SalesChannel["+getActivityProductListParamModel.SalesChannel+"]ProductType["+getActivityProductListParamModel.ProductType+"]���Żݲ�Ʒ��ȡ�ɹ�");
	}
}
