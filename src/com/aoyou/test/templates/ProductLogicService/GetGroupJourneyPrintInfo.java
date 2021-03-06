package com.aoyou.test.templates.ProductLogicService;

import com.aoyou.test.templates.NoInputParamTemplate;

public class GetGroupJourneyPrintInfo extends NoInputParamTemplate{

	@Override
	public void setURI() {
	
		uri = "http://productwebsitelogicservice.aoyou.com/GroupProductLogicService.svc";
		
	}

	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/IGroupProductLogicService/GetGroupJourneyPrintInfo");
	}

	@Override
	public void setRequestData() {
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:GetGroupJourneyPrintInfo>");
		requestData.append("<tem:productID>"+params.get("ProductID")+"</tem:productID>");
		requestData.append("</tem:GetGroupJourneyPrintInfo>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
		
	}

}
