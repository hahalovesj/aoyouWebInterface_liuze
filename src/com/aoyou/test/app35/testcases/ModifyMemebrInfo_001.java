package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.ModifyMemebrInfoResult;
import com.aoyou.test.app.request.ModifyMemebrInfoRequest;
import com.aoyou.test.app.request.param.model.ModifyMemebrInfoParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class ModifyMemebrInfo_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void modifyMemebrInfo_001(){
		
		this.test=new ModifyMemebrInfoRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		ModifyMemebrInfoParamModel modifyMemebrInfoParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		if(status==HttpStatus.OK.value()){
			ModifyMemebrInfoResult modifyMemebrInfoResult=(ModifyMemebrInfoResult) ((RestServiceTemplate) this.test).getResponseMode();
			this.checkPoint.equals(modifyMemebrInfoResult.Data, 0, "�˻���Ϣ�޸�ʧ�ܣ�");
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬��"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]�˻���Ϣ�޸ĳɹ����˻�name�޸�Ϊ["+modifyMemebrInfoParamModel.name+"]");
	}
}
