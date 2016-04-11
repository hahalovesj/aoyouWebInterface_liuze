package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetPreferredMerchantResult;
import com.aoyou.test.app.request.GetPreferredMerchantRequest;
import com.aoyou.test.app.request.param.model.GetPreferredMerchantParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetPreferredMerchant_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getPreferredMerchant_001(){
		
		this.test=new GetPreferredMerchantRequest();
		this.test.sendPost();
		
		System.out.println(this.test.getResponseString());
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		GetPreferredMerchantParamModel getPreferredMerchantParamModel=
				((RestServiceTemplate) this.test).getRequestParamMode();
		if(status==HttpStatus.OK.value()){
			GetPreferredMerchantResult result=(GetPreferredMerchantResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(result.ReturnCode==0){
				int size=result.Data.size();
				if(size>0){
					for(int i=0;i<size;i++){
						this.checkPoint.equals(result.Data.get(i).PM_ID, getPreferredMerchantParamModel.PMID,
								"回传PM_Country与期望不符，返回值为["+result.Data.get(i).PM_ID+"],期望值为["+getPreferredMerchantParamModel.PMID+"]");
					}
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]PMID["+getPreferredMerchantParamModel.PMID+"]的商户信息获取成功");
	}
}
