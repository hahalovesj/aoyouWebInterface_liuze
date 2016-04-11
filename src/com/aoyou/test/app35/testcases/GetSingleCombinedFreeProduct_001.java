package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetSingleCombinedFreeProductResult;
import com.aoyou.test.app.request.GetSingleCombinedFreeProductRequest;
import com.aoyou.test.app.request.param.model.GetCombinedProductPriceCalendarParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetSingleCombinedFreeProduct_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getSingleCombinedFreeProduct_001(){
		
		this.test=new GetSingleCombinedFreeProductRequest();
		this.test.sendPost();
		
		//System.out.println(this.test.getResponseString());
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		GetCombinedProductPriceCalendarParamModel getCombinedProductPriceCalendarParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		if(status==HttpStatus.OK.value()){
			GetSingleCombinedFreeProductResult getSingleCombinedFreeProductResult=(GetSingleCombinedFreeProductResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(getSingleCombinedFreeProductResult.ReturnCode==0){
				this.checkPoint.equals(getSingleCombinedFreeProductResult.Message, "成功", "执行消息值不正确,返回值为:["+getSingleCombinedFreeProductResult.Message+"],期望值为:[成功]");
				this.checkPoint.equals(getSingleCombinedFreeProductResult.Data.ProductID, getCombinedProductPriceCalendarParamModel.productID, "回传产品信息的ID与预期不符，返回值为:["+getSingleCombinedFreeProductResult.Data.ProductID+"],预期结果为:["+getCombinedProductPriceCalendarParamModel.productID+"]");
			}
		}else{
			
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]产品ID["+getCombinedProductPriceCalendarParamModel.productID+"]信息获取成功");
	}
}
