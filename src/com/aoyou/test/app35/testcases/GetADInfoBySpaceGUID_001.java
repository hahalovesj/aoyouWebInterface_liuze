package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetADInfoBySpaceGUIDResult;
import com.aoyou.test.app.request.GetADInfoBySpaceGUIDRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.google.gson.Gson;

public class GetADInfoBySpaceGUID_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getADInfoBySpaceGUID_001(){
		
		this.test=new GetADInfoBySpaceGUIDRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			Gson gson=new Gson();
			String responseString=this.test.getResponseString();
			GetADInfoBySpaceGUIDResult getADInfoBySpaceGUIDResult=gson.fromJson(responseString, GetADInfoBySpaceGUIDResult.class);
			
			if(getADInfoBySpaceGUIDResult.ReturnCode==0){
				this.checkPoint.equals(getADInfoBySpaceGUIDResult.Message, "���ָ��λ�õ���Ϣ����б�ɹ�", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getADInfoBySpaceGUIDResult.Message+"],����ֵΪ:[���ָ��λ�õ���Ϣ����б�ɹ�]");
				
				//���returncode=0 ����û�����ݷ��ص����
				int size=getADInfoBySpaceGUIDResult.Data.Advertisements.size();
				if(size>0){
					//�˴������ӽڵ���֤
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ��!״̬��"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]���ָ��λ�õ���Ϣ����б�ɹ�");
	}
}
