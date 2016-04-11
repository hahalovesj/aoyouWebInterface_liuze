package com.aoyou.test.templates.ProductLogicService;


import com.aoyou.test.templates.WebSerivceTemplate;

public class GetGroupProductBookingInfo extends WebSerivceTemplate{

	@Override
	public void setURI() {
		uri = "http://productwebsitelogicservice.aoyou.com/PackageProductLogicService.svc";
		
	}

	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/IPackageProductLogicService/GetGroupProductBookingInfo");
		
	}

	@Override
	public void setRequestData() {
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:GetGroupProductBookingInfo>");
		requestData.append("<tem:productID>"+params.get("ProductID")+"</tem:productID>");
		if(!params.get("DepartDate").equals("")){
			requestData.append("<tem:departDate>"+params.get("DepartDate")+"</tem:departDate>");
		}
		requestData.append("</tem:GetGroupProductBookingInfo>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
		
	}

	@Override
	public void initParams() {
		params.put("ProductID", "");
		params.put("DepartDate", "");
	}

}
