package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetIndexRecommendProductResult;
import com.aoyou.test.app.request.GetIndexRecommendProductRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.google.gson.Gson;

public class GetIndexRecommendProduct_001 extends TestBase{

	@BeforeClass 
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getIndexRecommendProduct_001(){
		
		this.test=new GetIndexRecommendProductRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			Gson gson=new Gson();
			String responseString=this.test.getResponseString();
			GetIndexRecommendProductResult getIndexRecommendProductResult=gson.fromJson(responseString, GetIndexRecommendProductResult.class);
			
			if(getIndexRecommendProductResult.ReturnCode==0){
				this.checkPoint.equals(getIndexRecommendProductResult.Message,"��ȡApp��ҳ�Ƽ���Ʒ�ɹ�","ִ����Ϣֵ����ȷ,����ֵΪ:["+getIndexRecommendProductResult.Message+"],����ֵΪ:[��ȡApp��ҳ�Ƽ���Ʒ�ɹ�]");
				
				//���returncode=0 ����û�����ݷ��ص����
				int size=getIndexRecommendProductResult.Data.size();
				if(size>0){
					//�˴������ӽڵ���֤
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ��!״̬��"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡ��ҳ�Ƽ���Ʒ�ɹ�");
	}
}
