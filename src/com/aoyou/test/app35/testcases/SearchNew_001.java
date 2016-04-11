package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.SearchNewResult;
import com.aoyou.test.app.request.SearchNewRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class SearchNew_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void searchNew_001(){
		
		this.test=new SearchNewRequest();
		this.test.sendPost();
		
		int status=this.test.getStatus();
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		
		if(status==HttpStatus.OK.value()){
			SearchNewResult searchNewResult=(SearchNewResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(searchNewResult.ReturnCode==0){
				this.checkPoint.equals(searchNewResult.Message,"产品列表查询成功!","执行消息值不正确,返回值为:["+searchNewResult.Message+"],期望值为:[产品列表查询成功!]");
			
				int size =searchNewResult.Data.FilterItemList.size();
				if(size>0){
					//此处加入子节点验证
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("接口调用失败！状态码:"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]产品列表查询成功!");
	}
}
