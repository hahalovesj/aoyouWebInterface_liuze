package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aoyou.test.app.Result.model.DestinationCityResult;
import com.aoyou.test.app.request.DestinationCityRequest;
import com.aoyou.test.app.request.param.model.DestinationCityParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.google.gson.Gson;

public class DestinationCity_001 extends TestBase{


	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	//国内
	@Test
	public void destinationCity_001(){
		
		this.test=new DestinationCityRequest();
		DestinationCityParamModel destinationCityParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		//国内目的地
		destinationCityParamModel.ForeignFlag=false;
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			DestinationCityResult destinationCityResult=(DestinationCityResult)((RestServiceTemplate)this.test).getResponseMode();
			if(destinationCityResult.ReturnCode==0){
				this.checkPoint.equals(destinationCityResult.Message,"获取目的地城市成功!","执行消息值不正确,返回值为:["+destinationCityResult.Message+"],期望值为:[获取目的地城市成功!]");
				int size =destinationCityResult.Data.size();
				if(size>0){
					//此处加入子节点验证
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败!状态码"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取[国内]目的地城市列表成功！");
	}
	
	//国外
	@Test
	public void destinationCity_002(){
		
		this.test=new DestinationCityRequest();
		DestinationCityParamModel destinationCityParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		//国内目的地
		destinationCityParamModel.ForeignFlag=true;
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			Gson gson=new Gson();
			String responseString=this.test.getResponseString();
			DestinationCityResult destinationCityResult=gson.fromJson(responseString, DestinationCityResult.class);
			if(destinationCityResult.ReturnCode==0){
				this.checkPoint.equals(destinationCityResult.Message,"获取目的地城市成功!","执行消息值不正确,返回值为:["+destinationCityResult.Message+"],期望值为:[获取目的地城市成功!]");
				int size =destinationCityResult.Data.size();
				//校验数据是够为空，message与code返回完成时
				if(size<=0){
					this.checkPoint.equals(size>0,true,"返回目的地城市为空！");
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败!状态码"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]获取[国外]目的地城市列表成功！");
	}
}
