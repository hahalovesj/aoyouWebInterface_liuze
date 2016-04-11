package com.aoyou.test.templates.bookingWebsiteLogicService;

import com.aoyou.test.templates.NoInputParamTemplate;
/**
 * @author renwei
 * @ClassName: VisaOrderReserve
 * @Description: 签证产品预定接口
 *
 */

public class VisaOrderReserve extends NoInputParamTemplate{

	@Override
	public void setURI() {
	
		uri = "http://bookingwebsitelogicservice.aoyou.com/BookingOrderService.svc";
		
	}

	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/IBookingOrderService/Reserve");
	}

	@Override
	public void setRequestData() {
		requestData.delete(0, requestData.length());
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:cyts=\"http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Booking.WebsiteLogic.Entity.Reserve\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:Reserve>");
		requestData.append("<tem:reserveView xsi:type=\"cyts:VisaOrderReserveView\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
		requestData.append("<cyts:ConfirmType>RealTimeOrder</cyts:ConfirmType>");
		requestData.append("<cyts:Contact>夏江</cyts:Contact>");
		requestData.append("<cyts:ContactEmail>fengrq@aoyou.com</cyts:ContactEmail>");
		requestData.append("<cyts:ContactMobile>18511452323</cyts:ContactMobile>");
		requestData.append("<cyts:Cooperation>");
		requestData.append("<arr:KeyValueOfstringArrayOfKeyValueOfstringstringty7Ep6D1>");
		requestData.append("<arr:Key>YiMa</arr:Key>");
		requestData.append("<arr:Value>");
		requestData.append("<arr:KeyValueOfstringstring><arr:Key>wi</arr:Key>");
		requestData.append("<arr:Value>NjA3NTE3fDAwNjQyOWM3YjJiNzE4MjgOZWVj</arr:Value>");
		requestData.append("</arr:KeyValueOfstringstring><arr:KeyValueOfstringstring>");
		requestData.append("<arr:Key>{[channel,cps]}</arr:Key>");
		requestData.append("<arr:Value>channel</arr:Value>");
		requestData.append("</arr:KeyValueOfstringstring><arr:KeyValueOfstringstring>");
		requestData.append("<arr:Key>{[activityFlag,w]}</arr:Key>");
		requestData.append("<arr:Value>activityFlag</arr:Value>");
		requestData.append("</arr:KeyValueOfstringstring><arr:KeyValueOfstringstring>");
		requestData.append("<arr:Key>{[src,emarcps]}</arr:Key>");
		requestData.append("<arr:Value>src</arr:Value>");
		requestData.append("</arr:KeyValueOfstringstring><arr:KeyValueOfstringstring>");
		requestData.append("<arr:Key>{[cid,6899]}</arr:Key>");
		requestData.append("<arr:Value>cid</arr:Value>");
		requestData.append("</arr:KeyValueOfstringstring>");
		requestData.append("</arr:Value>");
		requestData.append("</arr:KeyValueOfstringArrayOfKeyValueOfstringstringty7Ep6D1>");
		requestData.append("</cyts:Cooperation>");
		requestData.append("<cyts:CustomerID>11243740</cyts:CustomerID>");
		requestData.append("<cyts:CustomerName>夏江</cyts:CustomerName>");
		requestData.append("<cyts:DepartDate>2015-12-29T00:00:00.000+08:00</cyts:DepartDate>");
		requestData.append("<cyts:InputDept>019401</cyts:InputDept>");
		requestData.append("<cyts:InputUser>0</cyts:InputUser>");
		requestData.append("<cyts:IsAppContract>false</cyts:IsAppContract>");
		requestData.append("<cyts:IsCanPay>true</cyts:IsCanPay>");
		requestData.append("<cyts:IsContractConfirmed>true</cyts:IsContractConfirmed>");
		requestData.append("<cyts:MainSource>0</cyts:MainSource>");
		requestData.append("<cyts:MemberPoint>0</cyts:MemberPoint>");
		requestData.append("<cyts:OrderMoney>0</cyts:OrderMoney>");
		requestData.append("<cyts:ProductID>113</cyts:ProductID>");
		requestData.append("<cyts:Remark xsi:nil=\"true\"/>");
		requestData.append("<cyts:Source>0</cyts:Source>");
		requestData.append("<cyts:VoucherCodeList>");
		requestData.append("</cyts:VoucherCodeList>");
		requestData.append("<cyts:WorkOrderId>0</cyts:WorkOrderId>");
		requestData.append("<cyts:CompanyID>0</cyts:CompanyID>");
		requestData.append("<cyts:CustomerSource>2</cyts:CustomerSource>");
		requestData.append("<cyts:CustomerType>1</cyts:CustomerType>");
		requestData.append("<cyts:ExpressInfo>");
		requestData.append("<cyts:Address>北京海淀区</cyts:Address>");
		requestData.append("<cyts:CityID>1</cyts:CityID>");
		requestData.append("<cyts:Contact>18511452323</cyts:Contact>");
		requestData.append("<cyts:Contactor>夏江</cyts:Contactor>");
		requestData.append("<cyts:ExpressType>0</cyts:ExpressType>");
		requestData.append("<cyts:ProvinceID>-1</cyts:ProvinceID>");
		requestData.append("<cyts:ZipCode xsi:nil=\"true\"/>");
		requestData.append("</cyts:ExpressInfo>");
		requestData.append("<cyts:Passengers>");
		requestData.append("<cyts:CustomerInfoViewForCommon>");
		requestData.append("<cyts:Email xsi:nil=\"true\"/>");
		requestData.append("<cyts:IDCardNo xsi:nil=\"true\"/>");
		requestData.append("<cyts:IDCardType>Default</cyts:IDCardType>");
		requestData.append("<cyts:Name>测试</cyts:Name>");
		requestData.append("<cyts:Phone xsi:nil=\"true\"/>");
		requestData.append("<cyts:VisaID>1</cyts:VisaID>");
		requestData.append("<cyts:VisaName xsi:nil=\"true\"/>");
		requestData.append("</cyts:CustomerInfoViewForCommon>");
		requestData.append("</cyts:Passengers>");
		requestData.append("<cyts:TotalCount>1</cyts:TotalCount>");
		requestData.append("<cyts:VisaID>113</cyts:VisaID>");
		requestData.append("<cyts:VisaName xsi:nil=\"true\"/>");
		requestData.append("</tem:reserveView>");
		requestData.append("<tem:reservationType>Visa</tem:reservationType>");
		requestData.append("</tem:Reserve>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
		
		
	}

}
