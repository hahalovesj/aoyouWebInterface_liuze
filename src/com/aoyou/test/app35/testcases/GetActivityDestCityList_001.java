package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetActivityDestCityListResult;
import com.aoyou.test.app.request.GetActivityDestCityListRequest;
import com.aoyou.test.app.request.param.model.GetActivityDestCityListParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetActivityDestCityList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getActivityDestCityList_001(){
		
		this.test=new GetActivityDestCityListRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		GetActivityDestCityListParamModel getActivityDestCityListParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		if(status==HttpStatus.OK.value()){
			GetActivityDestCityListResult getActivityDestCityListResult=(GetActivityDestCityListResult)((RestServiceTemplate) this.test).getResponseMode();
			if(getActivityDestCityListResult.ReturnCode==0){
				this.checkPoint.equals(getActivityDestCityListResult.Message, "��ȡ���λ�ɸѡĿ�ĵ����ݳɹ�!", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getActivityDestCityListResult.Message+"],����ֵΪ:[��ȡ���λ�ɸѡĿ�ĵ����ݳɹ�!]");
			
				int size =getActivityDestCityListResult.Data.size();
				if(size>0){
					//�˴������ӽڵ���֤
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]CityID["+getActivityDestCityListParamModel.CityID+"]ProductType["+getActivityDestCityListParamModel.ProductType+"]��ȡ���λ�ɸѡĿ�ĵ����ݳɹ�!");
	}
}
