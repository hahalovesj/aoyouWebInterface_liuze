package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetIsCombinedByProductIDResult;
import com.aoyou.test.app.request.GetIsCombinedByProductIDRequest;
import com.aoyou.test.app.request.param.model.GetCombinedProductPriceCalendarParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetIsCombinedByProductID_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getIsCombinedByProductID_001(){
		
		this.test=new GetIsCombinedByProductIDRequest();
		this.test.sendPost();
		
		//System.out.println(this.test.getResponseString());
		GetCombinedProductPriceCalendarParamModel getCombinedProductPriceCalendarParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		
		if(status==HttpStatus.OK.value()){
			GetIsCombinedByProductIDResult getIsCombinedByProductIDResult=(GetIsCombinedByProductIDResult) ((RestServiceTemplate) this.test).getResponseMode();			
			this.checkPoint.equals(getIsCombinedByProductIDResult.Data.IsCombined, getCombinedProductPriceCalendarParamModel.isCombined, "产品是否Combined不符，返回值为["+getIsCombinedByProductIDResult.Data.IsCombined+"],期望结果为["+getCombinedProductPriceCalendarParamModel.isCombined+"]");
			if(getIsCombinedByProductIDResult.ReturnCode==0){
				this.checkPoint.equals(getIsCombinedByProductIDResult.Message, "是否为多机多酒产品调用成功!", "执行消息值不正确,返回值为:["+getIsCombinedByProductIDResult.Message+"],期望值为:[是否为多机多酒产品调用成功!]");
			}else{
				this.checkPoint.equals(getIsCombinedByProductIDResult.Message, "是否为多机多酒产品调用失败!", "执行消息值不正确,返回值为:["+getIsCombinedByProductIDResult.Message+"],期望值为:[是否为多机多酒产品调用失败!]");
			}
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]产品ID["+getCombinedProductPriceCalendarParamModel.productID+"]Combined产品状态为["+getCombinedProductPriceCalendarParamModel.isCombined+"]");
	}
}
