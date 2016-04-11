package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aoyou.test.app.request.MemberRegisterRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;

public class MemberRegister_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void memberRegister_001(){
		
		this.test=new MemberRegisterRequest();
		this.test.sendPost();
		
//		int runTime=((RestServiceTemplate) this.test).getRunTime();
//		int status=this.test.getStatus();
		
		System.out.println(this.test.getResponseString());
//		if(status==HttpStatus.OK.value()){
//			MemberRegisterResult memberRegisterResult=(MemberRegisterResult) ((RestServiceTemplate) this.test).getResponseMode();
//			
//		}else{
//			this.checkPoint.isFaild("½Ó¿ÚÇëÇóÊ§°Ü£¡×´Ì¬Âë:"+status);
//		}
//		
//		this.checkPoint.result("");
	}
}
