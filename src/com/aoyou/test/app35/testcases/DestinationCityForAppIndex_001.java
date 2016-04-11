package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.DestinationCityForAppIndexResult;
import com.aoyou.test.app.request.DestinationCityForAppIndexRequest;
import com.aoyou.test.app.request.param.model.DestinationCityForAppIndexParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class DestinationCityForAppIndex_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void destinationCityForAppIndex_001(){
		
		this.test=new DestinationCityForAppIndexRequest();
		DestinationCityForAppIndexParamModel destinationCityForAppIndexParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		destinationCityForAppIndexParamModel.ForeignFlag=false;
		this.test.sendPost();
		
		int status=this.test.getStatus();
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		
		if(status==HttpStatus.OK.value()){
			DestinationCityForAppIndexResult estinationCityForAppIndexResult=(DestinationCityForAppIndexResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(estinationCityForAppIndexResult.ReturnCode==0){
				this.checkPoint.equals(estinationCityForAppIndexResult.Message, "获取国内游、出镜游目的地城市成功!", "执行消息值不正确,返回值为:["+estinationCityForAppIndexResult.Message+"],期望值为:[获取国内游、出镜游目的地城市成功!]");
				
				int size =estinationCityForAppIndexResult.Data.Cities.size();
				if(size>0){
					//此处加入子节点验证
					for(int i=0;i<size;i++){
						this.checkPoint.equals(estinationCityForAppIndexResult.Data.Cities.get(i).GroupName, "国内", "回传城市分类名称与国内不符，返回值为:["+estinationCityForAppIndexResult.Data.Cities.get(i).GroupName+"],期望值为:[国内]");
					}
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("接口调用失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]国内城市获取成功！");
	}
	
	@Test
	public void destinationCityForAppIndex_002(){
		
		this.test=new DestinationCityForAppIndexRequest();
		this.test.sendPost();
		
		int status=this.test.getStatus();
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		
		if(status==HttpStatus.OK.value()){
			DestinationCityForAppIndexResult estinationCityForAppIndexResult=(DestinationCityForAppIndexResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(estinationCityForAppIndexResult.ReturnCode==0){
				this.checkPoint.equals(estinationCityForAppIndexResult.Message, "获取国内游、出镜游目的地城市成功!", "执行消息值不正确,返回值为:["+estinationCityForAppIndexResult.Message+"],期望值为:[获取国内游、出镜游目的地城市成功!]");
				
				int size =estinationCityForAppIndexResult.Data.Cities.size();
				if(size>0){
					//此处加入子节点验证
					for(int i=0;i<size;i++){
						this.checkPoint.equals(estinationCityForAppIndexResult.Data.Cities.get(i).GroupName, "出镜", "回传城市分类名称与国内不符，返回值为:["+estinationCityForAppIndexResult.Data.Cities.get(i).GroupName+"],期望值为:[境外]");
					}
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("接口调用失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]国内城市获取成功！");
	}
}
