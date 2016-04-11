package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetActivityHotSaleProductsResult;
import com.aoyou.test.app.request.GetActivityHotSaleProductsRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetActivityHotSaleProducts_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getActivityHotSaleProducts_001(){
		
		this.test=new GetActivityHotSaleProductsRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status =this.test.getStatus();
		
		if(status==HttpStatus.OK.value()){
			GetActivityHotSaleProductsResult getActivityHotSaleProductsResult=(GetActivityHotSaleProductsResult)((RestServiceTemplate)this.test).getResponseMode();
			
			if(getActivityHotSaleProductsResult.ReturnCode==0){
				this.checkPoint.equals(getActivityHotSaleProductsResult.Message, "��ȡApp����������Ʒ���ݳɹ�!", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getActivityHotSaleProductsResult.Message+"],����ֵΪ:[��ȡApp����������Ʒ���ݳɹ�!]");
				
				//���returncode=0 ����û�����ݷ��ص����
				int size=getActivityHotSaleProductsResult.Data.size();
				if(size>0){
					//�˴������ӽڵ���֤
					
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡApp����������Ʒ���ݳɹ�!");
	}
}
