package com.aoyou.test.cases.orderservice;

import java.util.List;
import org.testng.annotations.Test;
import com.aoyou.test.base.SetTest;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.listener.TestngRetry;
import com.aoyou.test.templates.orderservice.GetSelfGuidiedOrderInfoDetail;

/**
 * @author renwei
 * @ClassName: GetSelfGuidiedOrderInfoDetail001
 * @Description: 获取aoyouERP自由行订单详情信息
 *
 */
public class GetSelfGuidiedOrderInfoDetail001 extends TestBase{
	
	@Test(retryAnalyzer = TestngRetry.class)
	
	public void getSelfGuidiedOrderInfoDetail001(){
			
		SetTest test = new GetSelfGuidiedOrderInfoDetail();
		test.setParams("orderNo", "171102501153242");
		test.setParams("customerId", "11266537");
		test.sendPost();

		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);

			List<String> OrderType = px.getElementsText("//a:OrderType");
			List<String> AutoConfirmType = px.getElementsText("//a:AutoConfirmType");
			List<String> BeginCityId = px.getElementsText("//a:BeginCityId");
			List<String> Contactor = px.getElementsText("//a:Contactor");
			List<String> ContactorMobile = px.getElementsText("//a:ContactorMobile");
			List<String> CustomerName = px.getElementsText("//a:CustomerName");
			List<String> IsCanPay = px.getElementsText("//a:IsCanPay");
			List<String> IsNeedInvoice = px.getElementsText("//a:IsNeedInvoice");
			List<String> IsOccupyStock = px.getElementsText("//a:IsOccupyStock");
			List<String> OrderMoney = px.getElementsText("//a:OrderMoney");
			List<String> FeeItemNum = px.getElementsText("//a:FeeItemNum");
			List<String> OrderFeeId = px.getElementsText("//a:OrderFeeId");
			List<String> Price = px.getElementsText("//a:Price");
			List<String> AirLineName = px.getElementsText("//a:AirLineName");
			List<String> ArrivalAirPortName = px.getElementsText("//a:ArrivalAirPortName");
			List<String> ArrivalCityName = px.getElementsText("//a:ArrivalCityName");
			List<String> ContractName = px.getElementsText("//a:ContractName");
			List<String> HotelNameCH = px.getElementsText("//a:HotelNameCH");
			List<String> HotelProductID = px.getElementsText("//a:HotelProductID");
			List<String> CertificateNo = px.getElementsText("//a:CertificateNo");
			List<String> ContactMobile = px.getElementsText("//a:ContactMobile");
			List<String> LastName = px.getElementsText("//a:LastName");
			List<String> Name = px.getElementsText("//a:Name");
			List<String> Sex = px.getElementsText("//a:Sex");
	

			checkPoint.notEquals(OrderType, "");
			checkPoint.notEquals(OrderType, "0");
			checkPoint.notEquals(OrderType, null);
			checkPoint.notEquals(AutoConfirmType, "");
			checkPoint.notEquals(AutoConfirmType, "0");
			checkPoint.notEquals(AutoConfirmType, null);
			checkPoint.notEquals(BeginCityId, "");
			checkPoint.notEquals(BeginCityId, "0");
			checkPoint.notEquals(BeginCityId, null);
			checkPoint.notEquals(Contactor, "");
			checkPoint.notEquals(Contactor, "0");
			checkPoint.notEquals(Contactor, null);
			checkPoint.notEquals(ContactorMobile, "");
			checkPoint.notEquals(ContactorMobile, "0");
			checkPoint.notEquals(ContactorMobile, null);
			checkPoint.notEquals(CustomerName, "");
			checkPoint.notEquals(CustomerName, "0");
			checkPoint.notEquals(CustomerName, null);
			checkPoint.notEquals(IsCanPay, "");
			checkPoint.notEquals(IsCanPay, "0");
			checkPoint.notEquals(IsCanPay, null);
			checkPoint.notEquals(IsNeedInvoice, "");
			checkPoint.notEquals(IsNeedInvoice, "0");
			checkPoint.notEquals(IsNeedInvoice, null);
			checkPoint.notEquals(IsOccupyStock, "");
			checkPoint.notEquals(IsOccupyStock, "0");
			checkPoint.notEquals(IsOccupyStock, null);
			checkPoint.notEquals(OrderMoney, "");
			checkPoint.notEquals(OrderMoney, "0");
			checkPoint.notEquals(OrderMoney, null);
			checkPoint.notEquals(FeeItemNum, "");
			checkPoint.notEquals(FeeItemNum, "0");
			checkPoint.notEquals(FeeItemNum, null);
			checkPoint.notEquals(OrderFeeId, "");
			checkPoint.notEquals(OrderFeeId, "0");
			checkPoint.notEquals(OrderFeeId, null);
			checkPoint.notEquals(Price, "");
			checkPoint.notEquals(Price, "0");
			checkPoint.notEquals(Price, null);
			checkPoint.notEquals(AirLineName, "");
			checkPoint.notEquals(AirLineName, "0");
			checkPoint.notEquals(AirLineName, null);
			checkPoint.notEquals(ArrivalAirPortName, "");
			checkPoint.notEquals(ArrivalAirPortName, "0");
			checkPoint.notEquals(ArrivalAirPortName, null);
			checkPoint.notEquals(ArrivalCityName, "");
			checkPoint.notEquals(ArrivalCityName, "0");
			checkPoint.notEquals(ArrivalCityName, null);
			checkPoint.notEquals(ContractName, "");
			checkPoint.notEquals(ContractName, "0");
			checkPoint.notEquals(ContractName, null);
			checkPoint.notEquals(HotelNameCH, "");
			checkPoint.notEquals(HotelNameCH, "0");
			checkPoint.notEquals(HotelNameCH, null);
			checkPoint.notEquals(HotelProductID, "");
			checkPoint.notEquals(HotelProductID, "0");
			checkPoint.notEquals(HotelProductID, null);
			checkPoint.notEquals(CertificateNo, "");
			checkPoint.notEquals(CertificateNo, "0");
			checkPoint.notEquals(CertificateNo, null);
			checkPoint.notEquals(ContactMobile, "");
			checkPoint.notEquals(ContactMobile, "0");
			checkPoint.notEquals(ContactMobile, null);
			checkPoint.notEquals(LastName, "");
			checkPoint.notEquals(LastName, "0");
			checkPoint.notEquals(LastName, null);
			checkPoint.notEquals(Name, "");
			checkPoint.notEquals(Name, "0");
			checkPoint.notEquals(Name, null);
			checkPoint.notEquals(Sex, "");
			checkPoint.notEquals(Sex, "0");
			checkPoint.notEquals(Sex, null);
		
		}else{checkPoint.isFaild("接口请求失败!状态码："+test.getStatus());}
		checkPoint.result("GetSelfGuidiedOrderInfoDetail获取aoyouERP自由行订单详情信息");
	}	
	
}
