package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.TestBase;
import com.aoyou.test.base.Data;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.app.request.*;
import com.aoyou.test.app.request.param.model.AddMessageHitsParamModel;
import com.aoyou.test.app.Result.model.AddMessageHitsResult;

public class AddMessageHits_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	
	@Test
	public void addMessageHits(){
		
		this.test=new AddMessageHitsRequest();
		this.test.sendPost();
		//System.out.println(this.test.getResponseString());
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			//Gson gson=new Gson();
			//String responseString=this.test.getResponseString();
			AddMessageHitsResult addMessageHitsResult=(AddMessageHitsResult)((RestServiceTemplate)this.test).getResponseMode();
			this.checkPoint.equals(addMessageHitsResult.Message, "消息点击量统计成功", "执行消息值不正确,返回值为:["+addMessageHitsResult.Message+"],期望值为:[消息点击量统计成功]");
			this.checkPoint.equals(addMessageHitsResult.ReturnCode, 0, "执行消息代码不正确,返回值为:["+addMessageHitsResult.ReturnCode+"],期望值为:[0]");
			this.checkPoint.equals(addMessageHitsResult.Data, true, "执行结果不正确,返回值为 :["+addMessageHitsResult.Data+"],期望值为:[true]");
		}else{
			this.checkPoint.isFaild("接口请求失败!状态码"+status);
		}
		AddMessageHitsParamModel addMessageHitsParamModel=((RestServiceTemplate)this.test).getRequestParamMode();
		checkPoint.result("[执行时间:"+runTime+"ms]消息ID:["+addMessageHitsParamModel.ProMoID+"]消息类型:["+addMessageHitsParamModel.ProType+"]新增点击量成功！");
	}
}
