package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.DepartureCityVersionResult;
import com.aoyou.test.app.request.DepartureCityVersionRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class DepartureCityVersion_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void departureCityVersion_001(){
		
		this.test=new DepartureCityVersionRequest();
		this.test.sendPost();
		
		System.out.println(this.test.getResponseString());
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		DepartureCityVersionResult departureCityVersion=null;
		if(status==HttpStatus.OK.value()){
			 departureCityVersion=(DepartureCityVersionResult) ((RestServiceTemplate) this.test).getResponseMode();
			 if(departureCityVersion.ReturnCode==0){
				
			 }
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡ�����س�����Ϣ�汾�ɹ� !");
	}
}