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
				this.checkPoint.equals(getActivityProductListResult.Message, "获取抢游惠产品列表成功!", "执行消息值不正确,返回值为:["+getActivityProductListResult.Message+"],期望值为:[获取抢游惠产品列表成功!]");
				
				//验证节点完整性
				
			}
		}else{
			this.checkPoint.isFaild("接口调用失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]cityid["+getActivityProductListParamModel.cityid+"]destcityid["+getActivityProductListParamModel.destcityid+"]SalesChannel["+getActivityProductListParamModel.SalesChannel+"]ProductType["+getActivityProductListParamModel.ProductType+"]抢优惠产品获取成功");
	}
}
