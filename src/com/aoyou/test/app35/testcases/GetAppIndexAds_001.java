package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetAppIndexAdsResult;
import com.aoyou.test.app.request.GetAppIndexAdsRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.google.gson.Gson;

public class GetAppIndexAds_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getAppIndexAds_001(){
		
		this.test=new GetAppIndexAdsRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			Gson gson=new Gson();
			String responseString=this.test.getResponseString();
			GetAppIndexAdsResult getAppIndexAdsResult=gson.fromJson(responseString, GetAppIndexAdsResult.class);
			
			if(getAppIndexAdsResult.ReturnCode==0){
				this.checkPoint.equals(getAppIndexAdsResult.Message, "��ȡApp��ҳ����б�ɹ�!", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getAppIndexAdsResult.Message+"],����ֵΪ:[��ȡApp��ҳ����б�ɹ�!]");
				
				//���returncode=0 ����û�����ݷ��ص����
				int size=getAppIndexAdsResult.Data.size();
				if(size>0){
					//�˴������ӽڵ���֤
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ��!״̬��"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡ��ҳ����б�ɹ���");
	}
}
