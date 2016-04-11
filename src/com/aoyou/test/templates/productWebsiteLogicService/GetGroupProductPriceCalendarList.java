package com.aoyou.test.templates.productWebsiteLogicService;

import com.aoyou.test.templates.NoInputParamTemplate;

public class GetGroupProductPriceCalendarList extends NoInputParamTemplate{

	@Override
	public void setURI() {
	
		uri = "http://productwebsitelogicservice.aoyou.com/GroupProductLogicService.svc";
		
	}

	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/IGroupProductLogicService/GetGroupProductPriceCalendarList");
	}

	@Override
	public void setRequestData() {
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:GetGroupProductPriceCalendarList>");
		requestData.append("<tem:productID>"+params.get("ProductID")+"</tem:productID>");
		requestData.append("</tem:GetGroupProductPriceCalendarList>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
		
	}

}
