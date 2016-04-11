package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetActivityDepartCityListResult;
import com.aoyou.test.app.request.GetActivityDepartCityListRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetActivityDepartCityList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getActivityDepartCityList_001(){
		
		this.test=new GetActivityDepartCityListRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==HttpStatus.OK.value()){
			GetActivityDepartCityListResult getActivityDepartCityListResult=(GetActivityDepartCityListResult)((RestServiceTemplate) this.test).getResponseMode();
			if(getActivityDepartCityListResult.ReturnCode==0){
				this.checkPoint.equals(getActivityDepartCityListResult.Message, "��ȡ���Ż�ɸѡ���������ݳɹ�!", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getActivityDepartCityListResult.Message+"],����ֵΪ:[��ȡ���Ż�ɸѡ���������ݳɹ�!]");
				
				int size =getActivityDepartCityListResult.Data.size();
				if(size>0){
					//�˴������ӽڵ���֤
				}else{
					
				}
			}else{
				this.checkPoint.isFaild("�ӿڵ���ʧ�ܣ�״̬�룺"+status);
			}
			
			this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡ���Ż�ɸѡ���������ݳɹ�!");
		}
	}
}
