package com.aoyou.test.templates.ProductLogicService;

import com.aoyou.test.templates.NoInputParamTemplate;

public class GetCombinedProduct extends NoInputParamTemplate{


	@Override
	public void setURI() {
		uri = "http://productwebsitelogicservice.aoyou.com/CombinedProductLogicService.svc";		
	}

	@Override
	public void setHeaders() {
		headers.put("SOAPAction","http://tempuri.org/ICombinedProductLogicService/GetCombinedProduct");		
	}

	@Override
	public void setRequestData() {
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:GetCombinedProduct>");
		requestData.append("<tem:productID>"+params.get("ProductID")+"</tem:productID>");
		requestData.append("</tem:GetCombinedProduct>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
	}

}
