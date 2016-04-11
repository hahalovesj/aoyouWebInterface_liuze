package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetActivityProductTypesResult;
import com.aoyou.test.app.request.GetActivityProductTypesRequest;
import com.aoyou.test.app.request.param.model.GetDeptCityAdsParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetActivityProductTypes_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getActivityProductTypes_001(){
		
		this.test=new GetActivityProductTypesRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		GetDeptCityAdsParamModel getDeptCityAdsParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		if(status==HttpStatus.OK.value()){
			GetActivityProductTypesResult getActivityProductTypesResult=(GetActivityProductTypesResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(getActivityProductTypesResult.ReturnCode==0){
				this.checkPoint.equals(getActivityProductTypesResult.Message, "��ȡ���Ż�ɸѡ��Ʒ���ͳɹ�!", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getActivityProductTypesResult.Message+"],����ֵΪ:[��ȡ���Ż�ɸѡ��Ʒ���ͳɹ�!]");
			
				//���returncode=0 ����û�����ݷ��ص����
				int size=getActivityProductTypesResult.Data.size();
				if(size>0){
					//�˴������ӽڵ���֤
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]CityID["+getDeptCityAdsParamModel.CityID+"]��ȡ���Ż�ɸѡ��Ʒ���ͳɹ�!");
	}
}
