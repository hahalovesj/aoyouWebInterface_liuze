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
								"回传PM_Country与期望不符，返回值为["+result.Data.get(i).PM_Country+"],期望值为["+getPreferredMerchantListParamModel.Country+"]");
						this.checkPoint.equals(result.Data.get(i).PM_City, getPreferredMerchantListParamModel.City,
								"回传PM_City与期望不符，返回值为["+result.Data.get(i).PM_City+"],期望值为["+getPreferredMerchantListParamModel.City+"]");
						this.checkPoint.equals(result.Data.get(i).PM_Type, getPreferredMerchantListParamModel.Type,
								"回传PM_Type与期望不符，返回值为["+result.Data.get(i).PM_Type+"],期望值为["+getPreferredMerchantListParamModel.Type+"]");
					}
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码："+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]国家["+getPreferredMerchantListParamModel.Country+"]城市["+getPreferredMerchantListParamModel.City+"]类型["+getPreferredMerchantListParamModel.Type+"]的商家列表获取成功");
	}
}
