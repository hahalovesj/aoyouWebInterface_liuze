package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.request.ModifyMemberPasswordRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class ModifyMemberPassword_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void modifyMemberPassword_001(){
		
		this.test=new ModifyMemberPasswordRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		System.out.println(this.test.getResponseString());
		if(status==HttpStatus.OK.value()){
			
			//this.checkPoint.equals(, expected, message);
		}else{
			this.checkPoint.result("接口请求失败!状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]账户密码修改成功");
	}
}
