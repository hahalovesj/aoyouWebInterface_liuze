package com.aoyou.test.cases.orderservice;

import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetTravelers;

/**
 * @author renwei
 * @ClassName: GetTravelers001
 * @Description: 获取订单出行人信息
 *
 */
public class GetTravelers001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getTravelers001(){
			
		SetTest test = new GetTravelers();
		test.setParams("subOrderID", "1429527");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			
			String CertificateNo = px.getElementText("//a:CertificateNo");
			String CertificateType = px.getElementText("//a:CertificateType");
			String Name = px.getElementText("//a:Name");
			String Birthday = px.getElementText("//a:Birthday");
			String ContactMobile = px.getElementText("//a:ContactMobile");
			String FirstNamePinYin = px.getElementText("//a:FirstNamePinYin");
			String LastNamePinYin = px.getElementText("//a:LastNamePinYin");
			String Sex = px.getElementText("//a:Sex");
			
			checkPoint.notEqual(CertificateNo, "");
			checkPoint.notEqual(CertificateNo, "0");
			checkPoint.notEqual(CertificateNo, null);
			checkPoint.notEqual(CertificateType, "");
			checkPoint.notEqual(CertificateType, "0");
			checkPoint.notEqual(CertificateType, null);
			checkPoint.notEqual(Name, "");
			checkPoint.notEqual(Name, "0");
			checkPoint.notEqual(Name, null);
			checkPoint.notEqual(Birthday, "");
			checkPoint.notEqual(Birthday, "0");
			checkPoint.notEqual(Birthday, null);
			checkPoint.notEqual(ContactMobile, "");
			checkPoint.notEqual(ContactMobile, "0");
			checkPoint.notEqual(ContactMobile, null);
			checkPoint.notEqual(FirstNamePinYin, "");
			checkPoint.notEqual(FirstNamePinYin, "0");
			checkPoint.notEqual(FirstNamePinYin, null);
			checkPoint.notEqual(LastNamePinYin, "");
			checkPoint.notEqual(LastNamePinYin, "0");
			checkPoint.notEqual(LastNamePinYin, null);
			checkPoint.notEqual(Sex, "");
			checkPoint.notEqual(Sex, "0");
			checkPoint.notEqual(Sex, null);
			
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("GetTravelers获取订单出行人信息接口正确");
	}	
	
}
