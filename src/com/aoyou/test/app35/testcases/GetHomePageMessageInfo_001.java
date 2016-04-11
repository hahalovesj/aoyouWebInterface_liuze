package com.aoyou.test.app35.testcases;

import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetHomePageMessageInfoResult;
import com.aoyou.test.app.request.GetHomePageMessageInfoRequest;
import com.google.gson.Gson;

public class GetHomePageMessageInfo_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getHomePageMessageInfo_001(){
		
		this.test=new GetHomePageMessageInfoRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			Gson gson=new Gson();
			String requestString=this.test.getResponseString();
			GetHomePageMessageInfoResult getHomePageMessageInfoResult=gson.fromJson(requestString, GetHomePageMessageInfoResult.class);
			if(getHomePageMessageInfoResult.ReturnCode==0){
				int size=getHomePageMessageInfoResult.Data.size();
				if(size<=0){
					//this.checkPoint.equals(size>0, true, "��ȡ����ҳ��ϢΪ��");
				}else{
					this.checkPoint.equals(getHomePageMessageInfoResult.Message,"��ȡ��ҳ��Ϣ�ɹ�","ִ����Ϣֵ����ȷ,����ֵΪ:["+getHomePageMessageInfoResult.Message+"],����ֵΪ:[��ȡ��ҳ��Ϣ�ɹ�]");
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ��!״̬��"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡ��ҳ����ͷ����Ϣ�ɹ�");
	}
}
