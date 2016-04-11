package com.aoyou.test.templates.BookingOrderService;

import com.aoyou.test.templates.NoInputParamTemplate;
/**
 * @author renwei
 * @ClassName: FreeOrderReserve
 * @Description:  普通自由行预定接口
 *
 */

public class FreeOrderReserve extends NoInputParamTemplate{

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
		requestData.append("<tem:reserveView xsi:type=\"cyts:FreeOrderReserveView\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
		requestData.append("<cyts:ConfirmType>RealTimeOrder</cyts:ConfirmType>");
		requestData.append("<cyts:Contact>测试刘则</cyts:Contact>");
		requestData.append("<cyts:ContactEmail>liuze@aoyou.com</cyts:ContactEmail>");
		requestData.append("<cyts:ContactMobile>15810215321</cyts:ContactMobile>");
		requestData.append("<cyts:CustomerID>11266537</cyts:CustomerID>");
		requestData.append("<cyts:CustomerName>测试刘则</cyts:CustomerName>");
		requestData.append("<cyts:DepartDate>2016-04-20</cyts:DepartDate>");
		requestData.append("<cyts:InputDept xsi:nil=\"true\"/>");
		requestData.append("<cyts:IsAppContract>false</cyts:IsAppContract>");
		requestData.append("<cyts:IsCanPay>false</cyts:IsCanPay>");
		requestData.append("<cyts:IsContractConfirmed>true</cyts:IsContractConfirmed>");
		requestData.append("<cyts:ProductID>83105</cyts:ProductID>");
		requestData.append("<cyts:Remark xsi:nil=\"true\"/>");
		requestData.append("<cyts:TravelerList>");
		requestData.append("<cyts:TravelerView>");
		requestData.append("<cyts:CertificateNo>12345</cyts:CertificateNo>");
		requestData.append("<cyts:CertificateType>TaiWan</cyts:CertificateType>");
		requestData.append("<cyts:Name>测试刘则</cyts:Name>");
		requestData.append("<cyts:NamePinYin xsi:nil=\"true\"/>");
		requestData.append("<cyts:Birthday>1996-11-06</cyts:Birthday>");
		requestData.append("<cyts:ContactMobile>15810215321</cyts:ContactMobile>");
		requestData.append("<cyts:FirstNamePinYin>Ce</cyts:FirstNamePinYin>");
		requestData.append("<cyts:InputDept xsi:nil=\"true\"/>");
		requestData.append("<cyts:IsCustomer>false</cyts:IsCustomer>");
		requestData.append("<cyts:LastNamePinYin>shi</cyts:LastNamePinYin>");
		requestData.append("<cyts:ProductDept xsi:nil=\"true\"/>");
		requestData.append("<cyts:Sex>1</cyts:Sex>");
		requestData.append("<cyts:TransportInfo>");
		requestData.append("<cyts:IsNeedTransportService>false</cyts:IsNeedTransportService>");
		requestData.append("</cyts:TransportInfo>");
		requestData.append("<cyts:TravelCardBirthCityName xsi:nil=\"true\"/>");
		requestData.append("<cyts:TravelCardNo xsi:nil=\"true\"/>");
		requestData.append("<cyts:TravelCardSignDate xsi:nil=\"true\"/>");
		requestData.append("<cyts:TravelCardValidDate xsi:nil=\"true\"/>");
		requestData.append("</cyts:TravelerView>");
		requestData.append("</cyts:TravelerList>");
		requestData.append("<cyts:VoucherCodeList>");
		requestData.append("</cyts:VoucherCodeList>");
		requestData.append("<cyts:AdultCount>1</cyts:AdultCount>");
		requestData.append("<cyts:ChildCount>0</cyts:ChildCount>");
		requestData.append("<cyts:RoomCount>1</cyts:RoomCount>");
		requestData.append("</tem:reserveView>");
		requestData.append("<tem:reservationType>FreeTour</tem:reservationType>");
		requestData.append("</tem:Reserve>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
		
		
	}

}
