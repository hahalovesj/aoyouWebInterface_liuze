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
				this.checkPoint.equals(getSingleCombinedFreeProductResult.Message, "�ɹ�", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getSingleCombinedFreeProductResult.Message+"],����ֵΪ:[�ɹ�]");
				this.checkPoint.equals(getSingleCombinedFreeProductResult.Data.ProductID, getCombinedProductPriceCalendarParamModel.productID, "�ش���Ʒ��Ϣ��ID��Ԥ�ڲ���������ֵΪ:["+getSingleCombinedFreeProductResult.Data.ProductID+"],Ԥ�ڽ��Ϊ:["+getCombinedProductPriceCalendarParamModel.productID+"]");
			}
		}else{
			
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ƷID["+getCombinedProductPriceCalendarParamModel.productID+"]��Ϣ��ȡ�ɹ�");
	}
}
