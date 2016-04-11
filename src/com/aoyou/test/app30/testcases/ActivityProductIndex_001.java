package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.ActivityProductIndexResult;
import com.aoyou.test.app.request.ActivityProductIndexRequest;
import com.aoyou.test.app.request.param.model.ActivityProductIndexParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class ActivityProductIndex_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void activityProductIndex_001(){
		
		this.test=new ActivityProductIndexRequest();
		this.test.sendPost();
		
		//System.out.println(this.test.getResponseString());
		ActivityProductIndexParamModel activityProductIndexParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==HttpStatus.OK.value()){
			ActivityProductIndexResult result=(ActivityProductIndexResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(result.ReturnCode==0){
				this.checkPoint.equals(result.Data.ActivityID, activityProductIndexParamModel.ActivityID, "�ش����Żݲ�ƷID��һ�£�����ֵΪ["+result.Data.ActivityID+"],����ֵΪ["+activityProductIndexParamModel.ActivityID+"]");
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ɹ���״̬�룺"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]���Żݲ�ƷID["+activityProductIndexParamModel.ActivityID+"]��Ϣ��ȡ�ɹ�");
		
	}
}
