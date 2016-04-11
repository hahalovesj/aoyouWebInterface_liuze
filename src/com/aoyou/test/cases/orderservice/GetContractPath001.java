package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetContractPath;

/**
 * @author renwei
 * @ClassName: GetContractPath001
 * @Description: 获取合同地址
 *
 */
public class GetContractPath001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getContractPath001(){
			
		SetTest test = new GetContractPath();
	
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.microsoft.com/2003/10/Serialization/Arrays");
			px.Load(responseString);
			
			String Key = px.getElementText("//a:Key");
			String Value = px.getElementText("//a:Value");
			
			checkPoint.notEqual(Key, "");
			checkPoint.notEqual(Key, "0");
			checkPoint.notEqual(Key, null);
			checkPoint.notEqual(Value, "");
			checkPoint.notEqual(Value, "0");
			checkPoint.notEqual(Value, null);
	
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("GetContractPath获取合同地址接口正确");
	}	
	
}
