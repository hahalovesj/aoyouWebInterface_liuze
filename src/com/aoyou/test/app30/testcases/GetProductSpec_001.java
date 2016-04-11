package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetProductSpecResult;
import com.aoyou.test.app.request.GetProductSpecRequest;
import com.aoyou.test.app.request.param.model.GetProductSpecParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetProductSpec_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getProductSpec_001(){
		
		this.test=new GetProductSpecRequest();
		this.test.sendPost();
		
		 System.out.println(this.test.getResponseString());
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		GetProductSpecParamModel getProductSpecParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		if(status==HttpStatus.OK.value()){
			GetProductSpecResult result=(GetProductSpecResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(result.ReturnCode==0){
				int size=result.Data.size();
				for(int i=0;i<size;i++){
					this.checkPoint.equals(result.Data.get(i).Pro_Mo_ID, getProductSpecParamModel.ProMoID, "回传的ProMoID不正确，返回值为：["+result.Data.get(i).Pro_Mo_ID+"],期望值为:["+getProductSpecParamModel.ProMoID+"]");
					this.checkPoint.equals(result.Data.get(i).Pro_Mo_Type, getProductSpecParamModel.ProType, "回传的ProType不正确，返回值为：["+result.Data.get(i).Pro_Mo_Type+"],期望值为:["+getProductSpecParamModel.ProType+"]");
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取ProMoID["+getProductSpecParamModel.ProMoID+"]ProType["+getProductSpecParamModel.ProType+"]的产品信息成功");
		
	}
}
