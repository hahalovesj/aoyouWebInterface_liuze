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
					this.checkPoint.equals(result.Data.get(i).Pro_Mo_ID, getProductSpecParamModel.ProMoID, "�ش���ProMoID����ȷ������ֵΪ��["+result.Data.get(i).Pro_Mo_ID+"],����ֵΪ:["+getProductSpecParamModel.ProMoID+"]");
					this.checkPoint.equals(result.Data.get(i).Pro_Mo_Type, getProductSpecParamModel.ProType, "�ش���ProType����ȷ������ֵΪ��["+result.Data.get(i).Pro_Mo_Type+"],����ֵΪ:["+getProductSpecParamModel.ProType+"]");
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡProMoID["+getProductSpecParamModel.ProMoID+"]ProType["+getProductSpecParamModel.ProType+"]�Ĳ�Ʒ��Ϣ�ɹ�");
		
	}
}
