package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.AddAttachmentResult;
import com.aoyou.test.app.request.AddAttachmentRequest;
import com.aoyou.test.app.request.param.model.AddAttachmentParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class AddAttachment_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void addAttachment_001(){
		
		this.test=new AddAttachmentRequest();
		this.test.sendPost();
		AddAttachmentParamModel addAttachmentParamModel=((RestServiceTemplate)this.test).getRequestParamMode();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==HttpStatus.OK.value()){
			AddAttachmentResult  addAttachmentResult = (AddAttachmentResult) ((RestServiceTemplate)this.test).getResponseMode();
			if(addAttachmentResult.ReturnCode==0){
				this.checkPoint.equals(addAttachmentResult.Message, "新增图片成功", "");
			}
		}else{
			this.checkPoint.isFaild("接口请求失败，状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间 :"+runTime+"ms]上传图片["+addAttachmentParamModel.CoverImg+"]成功");
	}
}
