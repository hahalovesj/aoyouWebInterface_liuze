package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.DepartureCityResult;
import com.aoyou.test.app.request.DepartureCityRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;

public class DepartureCity_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void departureCity_001(){
		
		this.test=new DepartureCityRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			DepartureCityResult departureCityResult=(DepartureCityResult)((RestServiceTemplate)this.test).getResponseMode();
			if(departureCityResult.ReturnCode==0){
				this.checkPoint.equals(departureCityResult.Message,"��ȡApp�����س�����Ϣ�ɹ�!","ִ����Ϣֵ����ȷ,����ֵΪ:["+departureCityResult.Message+"],����ֵΪ:[��ȡApp�����س�����Ϣ�ɹ�!]");
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ��!״̬��"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡ�����س����б�ɹ���");
	}
}
