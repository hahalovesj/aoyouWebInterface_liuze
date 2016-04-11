package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetPreferredMerchantListResult;
import com.aoyou.test.app.request.GetPreferredMerchantListRequest;
import com.aoyou.test.app.request.param.model.GetPreferredMerchantListParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetPreferredMerchantList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getPreferredMerchantList_001(){
		
		this.test=new GetPreferredMerchantListRequest();
		this.test.sendPost();
		
		//System.out.println(this.test.getResponseString());
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		GetPreferredMerchantListParamModel getPreferredMerchantListParamModel=
				((RestServiceTemplate) this.test).getRequestParamMode();
		if(status==HttpStatus.OK.value()){
			GetPreferredMerchantListResult result=
					(GetPreferredMerchantListResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(result.ReturnCode==0){
				int size=result.Data.size();
				if(size>0){
					for(int i=0;i<size;i++){
						this.checkPoint.equals(result.Data.get(i).PM_Country, getPreferredMerchantListParamModel.Country,
								"�ش�PM_Country����������������ֵΪ["+result.Data.get(i).PM_Country+"],����ֵΪ["+getPreferredMerchantListParamModel.Country+"]");
						this.checkPoint.equals(result.Data.get(i).PM_City, getPreferredMerchantListParamModel.City,
								"�ش�PM_City����������������ֵΪ["+result.Data.get(i).PM_City+"],����ֵΪ["+getPreferredMerchantListParamModel.City+"]");
						this.checkPoint.equals(result.Data.get(i).PM_Type, getPreferredMerchantListParamModel.Type,
								"�ش�PM_Type����������������ֵΪ["+result.Data.get(i).PM_Type+"],����ֵΪ["+getPreferredMerchantListParamModel.Type+"]");
					}
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬�룺"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]����["+getPreferredMerchantListParamModel.Country+"]����["+getPreferredMerchantListParamModel.City+"]����["+getPreferredMerchantListParamModel.Type+"]���̼��б��ȡ�ɹ�");
	}
}
