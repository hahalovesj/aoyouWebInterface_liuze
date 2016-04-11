package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetActivityPanicBuyingProductsResult;
import com.aoyou.test.app.request.GetActivityPanicBuyingProductsRequest;
import com.aoyou.test.app.request.param.model.GetDeptCityAdsParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetActivityPanicBuyingProducts_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getActivityPanicBuyingProducts_001(){
		
		this.test=new GetActivityPanicBuyingProductsRequest();
		this.test.sendPost();
		
		GetDeptCityAdsParamModel getDeptCityAdsParamModel=((RestServiceTemplate)this.test).getRequestParamMode();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		System.out.println(this.test.getResponseString());
		if(status==HttpStatus.OK.value()){
			GetActivityPanicBuyingProductsResult getActivityPanicBuyingProductsResult=(GetActivityPanicBuyingProductsResult)((RestServiceTemplate)this.test).getResponseMode();
			
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
