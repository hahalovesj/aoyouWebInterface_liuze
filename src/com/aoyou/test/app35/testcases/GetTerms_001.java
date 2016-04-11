package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetTermsResult;
import com.aoyou.test.app.request.GetTermsRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.google.gson.Gson;

public class GetTerms_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getTerms_001(){
		
		this.test=new GetTermsRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status = this.test.getStatus();
		
		if(status==200){
			Gson gson=new Gson();
			String responseString=this.test.getResponseString();
			GetTermsResult getTermsResult=gson.fromJson(responseString, GetTermsResult.class);
			
			if(getTermsResult.ReturnCode==0){
				this.checkPoint.equals(getTermsResult.Message, "��ȡָ�����������ݳɹ�", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getTermsResult.Message+"],����ֵΪ:[��ȡָ�����������ݳɹ�]");
				
				int size =getTermsResult.Data.size();
				if(size>0){
					//�˴������ӽڵ���֤
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ��!״̬��"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡָ�����������ݳɹ���");
	}
}
