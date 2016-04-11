package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetCouponsInfoByUserIDResult;
import com.aoyou.test.app.request.GetCouponsInfoByUserIDRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetCouponsInfoByUserID_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getCouponsInfoByUserID_001(){
		
		this.test=new GetCouponsInfoByUserIDRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		
		if(status==HttpStatus.OK.value()){
			GetCouponsInfoByUserIDResult getCouponsInfoByUserIDResult=(GetCouponsInfoByUserIDResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(getCouponsInfoByUserIDResult.ReturnCode==0){
				this.checkPoint.equals(getCouponsInfoByUserIDResult.Message,"获取优惠券列表成功","执行消息值不正确,返回值为:["+getCouponsInfoByUserIDResult.Message+"],期望值为:[查询主题信息成功]");
			}
		}else{
			this.checkPoint.isFaild("接口调用失败！状态码： "+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]优惠券获取成功！");
	}
}
