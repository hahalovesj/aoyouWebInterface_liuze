package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aoyou.test.app.Result.model.GetNewActivityPanicBuyingProductsResult;
import com.aoyou.test.app.request.GetNewActivityPanicBuyingProductsRequest;
import com.aoyou.test.app.request.param.model.GetNewActivityPanicBuyingProductsParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetNewActivityPanicBuyingProducts_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getNewActivityPanicBuyingProducts_001(){
		
		this.test=new GetNewActivityPanicBuyingProductsRequest();
		this.test.sendPost();
		
		GetNewActivityPanicBuyingProductsParamModel getDeptCityAdsParamModel=((RestServiceTemplate)this.test).getRequestParamMode();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		//System.out.println(this.test.getResponseString());
		if(status==HttpStatus.OK.value()){
			GetNewActivityPanicBuyingProductsResult getActivityPanicBuyingProductsResult=(GetNewActivityPanicBuyingProductsResult)((RestServiceTemplate)this.test).getResponseMode();
			
			if(getActivityPanicBuyingProductsResult.ReturnCode==0){
				this.checkPoint.equals(getActivityPanicBuyingProductsResult.Message, "��ȡApp������Ʒ���ݳɹ�!", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getActivityPanicBuyingProductsResult.Message+"],����ֵΪ:[��ȡApp������Ʒ���ݳɹ�!]");
				
				//���returncode=0 ����û�����ݷ��ص����
				int size=getActivityPanicBuyingProductsResult.Data.size();
				if(size>0){
					//�˴������ӽڵ���֤
					
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬��Ϊ:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]CityID["+getDeptCityAdsParamModel.CityID+"]��ȡApp������Ʒ���ݳɹ�!");
	}
}
