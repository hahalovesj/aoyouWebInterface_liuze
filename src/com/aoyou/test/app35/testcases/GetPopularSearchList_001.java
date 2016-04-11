package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetPopularSearchListResult;
import com.aoyou.test.app.request.GetPopularSearchListRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetPopularSearchList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getPopularSearchList_001(){
		
		this.test=new GetPopularSearchListRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
			
		if(status==HttpStatus.OK.value()){
			GetPopularSearchListResult getPopularSearchListResult=(GetPopularSearchListResult) ((RestServiceTemplate)this.test).getResponseMode();
			if(getPopularSearchListResult.ReturnCode==0){
				this.checkPoint.equals(getPopularSearchListResult.Message, "���ű�ǩ��ȡ�ɹ�!", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getPopularSearchListResult.Message+"],����ֵΪ:[���ű�ǩ��ȡ�ɹ�!]");
				
				int size =getPopularSearchListResult.Data.size();
				if(size>0){
					//�˴������ӽڵ���֤
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ��!״̬��Ϊ:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]���ű�ǩ��ȡ�ɹ�!");
	}
}
