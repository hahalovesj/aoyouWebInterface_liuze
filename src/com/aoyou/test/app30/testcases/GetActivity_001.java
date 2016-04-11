package com.aoyou.test.app30.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetActivityResult;
import com.aoyou.test.app.request.GetActivityRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetActivity_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getActivity_001(){
		
		this.test=new GetActivityRequest();
		this.test.sendPost();
		
		//System.out.println(this.test.getResponseString());
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==HttpStatus.OK.value()){
			GetActivityResult getActivityResult=(GetActivityResult) ((RestServiceTemplate) this.test).getResponseMode();
			this.checkPoint.equals(getActivityResult.Message, "��ȡApp��������ݳɹ�", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getActivityResult.Message+"],����ֵΪ:[��ȡApp��������ݳɹ�]");
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡApp��������ݳɹ�");
	}
}