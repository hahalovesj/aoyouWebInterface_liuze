package com.aoyou.test.templates.SearchWebsiteLogicService;

import com.aoyou.test.templates.NoInputParamTemplate;


public class GetRightSideAdvert extends NoInputParamTemplate{

	@Override
	public void setURI() {
		uri = "http://searchwebsitelogicservice.aoyou.com/SearchWebsiteLogicService.svc";
			
	}

	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/ISearchWebsiteLogicService/GetRightSideAdvert");
			
	}

	@Override
	public void setRequestData() {
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:GetRightSideAdvert/>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");		
	}
		
}
