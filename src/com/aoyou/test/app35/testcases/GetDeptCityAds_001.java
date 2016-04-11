package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetDeptCityAdsResult;
import com.aoyou.test.app.request.GetDeptCityAdsRequest;
import com.aoyou.test.app.request.param.model.GetDeptCityAdsParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetDeptCityAds_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getDeptCityAds_001(){
		
		this.test=new GetDeptCityAdsRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		GetDeptCityAdsParamModel getDeptCityAdsParamModel=((RestServiceTemplate)this.test).getRequestParamMode();
		int status=this.test.getStatus();
		
		if(status==HttpStatus.OK.value()){
			GetDeptCityAdsResult getDeptCityAdsResult=(GetDeptCityAdsResult)((RestServiceTemplate)this.test).getResponseMode();
			if(getDeptCityAdsResult.ReturnCode==0){
				this.checkPoint.equals(getDeptCityAdsResult.Message, "��ȡApp��ҳ����б�ɹ�!", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getDeptCityAdsResult.Message+"],����ֵΪ:[��ȡApp��ҳ����б�ɹ�!]");
				
				//���returncode=0 ����û�����ݷ��ص����
				int size=getDeptCityAdsResult.Data.size();
				if(size>0){
					//�˴������ӽڵ���֤
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬��Ϊ:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]CityIDΪ["+getDeptCityAdsParamModel.CityID+"]��Ŀ�ĵ�ͼƬ��ȡ�ɹ�");
	}
}
