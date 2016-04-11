package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetVisaTypeInfoResult;
import com.aoyou.test.app.request.GetVisaTypeInfoRequest;
import com.aoyou.test.app.request.param.model.GetVisaTypeInfoParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetVisaTypeInfo_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getVisaTypeInfo_001(){
		
		this.test=new GetVisaTypeInfoRequest();
		this.test.sendPost();
		
		System.out.println(this.test.getResponseString());
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		GetVisaTypeInfoParamModel getVisaTypeInfoParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		if(status==HttpStatus.OK.value()){
			GetVisaTypeInfoResult result=(GetVisaTypeInfoResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(result.ReturnCode==0){
				int size =result.Data.size();
				for(int i=0;i<size-1;i++){
					this.checkPoint.equals(result.Data.get(i).CountryID, getVisaTypeInfoParamModel.CountryID, "���صĳ���ID��һ�£�����ֵΪ["+result.Data.get(i).CountryID+"],����ֵΪ["+getVisaTypeInfoParamModel.CountryID+"]");
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��["+runTime+"ms]CountryID["+getVisaTypeInfoParamModel.CountryID+"]��ǩ֤������Ϣ��ȡ�ɹ�");
	}
}
