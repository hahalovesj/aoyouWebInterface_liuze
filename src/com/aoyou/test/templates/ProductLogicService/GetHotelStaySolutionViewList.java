package com.aoyou.test.templates.ProductLogicService;

import com.aoyou.test.templates.WebSerivceTemplate;

public class GetHotelStaySolutionViewList extends WebSerivceTemplate{

	@Override
	public void setURI() {
		uri = "http://productwebsitelogicservice.aoyou.com/CombinedProductLogicService.svc";	
	}

	@Override
	public void setHeaders() {
		headers.put("SOAPAction","http://tempuri.org/ICombinedProductLogicService/GetHotelStaySolutionViewList");		
	}

	@Override
	public void initParams() {
		params.put("ProductID", "");
		params.put("DepartDate", "");
	}

	@Override
	public void setRequestData() {
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:GetHotelStaySolutionViewList>");
		requestData.append("<tem:productID>"+params.get("ProductID")+"</tem:productID>");
		requestData.append("<tem:departDate>"+params.get("DepartDate")+"</tem:departDate>");
		requestData.append("</tem:GetHotelStaySolutionViewList>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
				
	}

}
