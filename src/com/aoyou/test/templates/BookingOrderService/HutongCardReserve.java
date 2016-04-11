package com.aoyou.test.templates.BookingOrderService;

import com.aoyou.test.templates.NoInputParamTemplate;

/**
 * @author renwei
 * @ClassName: HutongCardReserve
 * @Description:  互通卡预定接口
 *
 */

public class HutongCardReserve extends NoInputParamTemplate{

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
		requestData.append("<tem:reserveView xsi:type=\"cyts:HutongCardReserveView\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
		requestData.append("<cyts:ConfirmType>RealTimeOrder</cyts:ConfirmType>");
		requestData.append("<cyts:Contact>测试刘则</cyts:Contact>");
		requestData.append("<cyts:ContactEmail>liuze@aoyou.com</cyts:ContactEmail>");
		requestData.append("<cyts:ContactMobile>15810215321</cyts:ContactMobile>");
		requestData.append("<cyts:Cooperation>");
		requestData.append("<arr:KeyValueOfstringArrayOfKeyValueOfstringstringty7Ep6D1>");
		requestData.append("<arr:Key>1</arr:Key>");
		requestData.append("<arr:Value>");
		requestData.append("<arr:KeyValueOfstringstring>");
		requestData.append("<arr:Key>1</arr:Key>");
		requestData.append("<arr:Value>1</arr:Value>");
		requestData.append("</arr:KeyValueOfstringstring>");
		requestData.append("</arr:Value>");
		requestData.append("</arr:KeyValueOfstringArrayOfKeyValueOfstringstringty7Ep6D1>");
		requestData.append("</cyts:Cooperation>");
		requestData.append("<cyts:CustomerID>11266537</cyts:CustomerID><cyts:CustomerName>测试刘则</cyts:CustomerName>");
		requestData.append("<cyts:InputDept xsi:nil=\"true\"/>");
		requestData.append("<cyts:Invoice>");
		requestData.append("<cyts:Address>北京西城区</cyts:Address>");
		requestData.append("<cyts:Contact>测试刘则</cyts:Contact>");
		requestData.append("<cyts:InvoiceTitle>发票抬头</cyts:InvoiceTitle>");
		requestData.append("<cyts:InvoiceType>8</cyts:InvoiceType><cyts:Mobile>15810215321</cyts:Mobile>");
		requestData.append("<cyts:OrderNo xsi:nil=\"true\"/>");
		requestData.append("<cyts:PostCode>100100</cyts:PostCode>");
		requestData.append("<cyts:SendMode xsi:nil=\"true\"/>");
		requestData.append("</cyts:Invoice>");
		requestData.append("<cyts:IsAppContract>false</cyts:IsAppContract>");
		requestData.append("<cyts:IsCanPay>false</cyts:IsCanPay>");
		requestData.append("<cyts:IsContractConfirmed>false</cyts:IsContractConfirmed>");
		requestData.append("<cyts:ProductID>0</cyts:ProductID>");
		requestData.append("<cyts:Remark xsi:nil=\"true\"/>");
		requestData.append("<cyts:TravelerList>");
		requestData.append("<cyts:TravelerView>");
		requestData.append("<cyts:CertificateNo xsi:nil=\"true\"/>");
		requestData.append("<cyts:Name xsi:nil=\"true\"/>");
		requestData.append("<cyts:NamePinYin xsi:nil=\"true\"/>");
		requestData.append("<cyts:Birthday xsi:nil=\"true\"/>");
		requestData.append("<cyts:ContactMobile xsi:nil=\"true\"/>");
		requestData.append("<cyts:FirstNamePinYin xsi:nil=\"true\"/>");
		requestData.append("<cyts:InputDept xsi:nil=\"true\"/>");
		requestData.append("<cyts:LastNamePinYin xsi:nil=\"true\"/>");
		requestData.append("<cyts:ProductDept xsi:nil=\"true\"/>");
		requestData.append("<cyts:TransportInfo>");
		requestData.append("<cyts:AirPortName xsi:nil=\"true\"/>");
		requestData.append("<cyts:CityName xsi:nil=\"true\"/>");
		requestData.append("</cyts:TransportInfo>");
		requestData.append("<cyts:TravelCardBirthCityName xsi:nil=\"true\"/>");
		requestData.append("<cyts:TravelCardNo xsi:nil=\"true\"/>");
		requestData.append("<cyts:TravelCardSignDate xsi:nil=\"true\"/>");
		requestData.append("<cyts:TravelCardValidDate xsi:nil=\"true\"/>");
		requestData.append("</cyts:TravelerView>");
		requestData.append("</cyts:TravelerList>");
		requestData.append("<cyts:VoucherCodeList>");
		requestData.append("</cyts:VoucherCodeList>");
		requestData.append("<cyts:CardType>true</cyts:CardType>");
		requestData.append("<cyts:ContactIDCard>130822198802060513</cyts:ContactIDCard>");
		requestData.append("<cyts:ExpressInfo>");
		requestData.append("<cyts:Address>北京西城区</cyts:Address>");
		requestData.append("<cyts:Contact>15810215321</cyts:Contact>");
		requestData.append("<cyts:Contactor>测试刘则</cyts:Contactor>");
		requestData.append("<cyts:ExpressType>0</cyts:ExpressType>");
		requestData.append("<cyts:ProvinceID>0</cyts:ProvinceID>");
		requestData.append("<cyts:ZipCode>100100</cyts:ZipCode>");
		requestData.append("</cyts:ExpressInfo>");
		requestData.append("<cyts:InputDeptCode xsi:nil=\"true\"/>");
		requestData.append("<cyts:InvoiceContentName xsi:nil=\"true\"/>");
		requestData.append("<cyts:InvoiceHeader xsi:nil=\"true\"/>");
		requestData.append("<cyts:bookInfo>");
		requestData.append("<cyts:HutongCardBookInfo>");
		requestData.append("<cyts:CostPrice>0</cyts:CostPrice>");
		requestData.append("<cyts:ProductId>2650</cyts:ProductId>");
		requestData.append("<cyts:TotalCount>1</cyts:TotalCount>");
		requestData.append("</cyts:HutongCardBookInfo>");
		requestData.append("</cyts:bookInfo>");
		requestData.append("</tem:reserveView>");
		requestData.append("<tem:reservationType>HutongCard</tem:reservationType>");
		requestData.append("</tem:Reserve>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
		
	}

}
