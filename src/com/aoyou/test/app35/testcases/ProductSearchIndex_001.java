package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.request.ProductSearchIndexRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;

public class ProductSearchIndex_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void productSearchIndex_001(){
		
		this.test=new ProductSearchIndexRequest();
		this.test.sendPost();
		
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			
		}else{
			this.checkPoint.isFaild("接口请求失败！状态码："+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]");
	}
}
