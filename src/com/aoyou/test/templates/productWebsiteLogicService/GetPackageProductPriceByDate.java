package com.aoyou.test.templates.productWebsiteLogicService;

import com.aoyou.test.templates.WebSerivceTemplate;

public class GetPackageProductPriceByDate extends WebSerivceTemplate{

	@Override
	public void setURI() {
		uri = "http://productwebsitelogicservice.aoyou.com/PackageProductLogicService.svc";	
	}

	@Override
	public void setHeaders() {
		headers.put("SOAPAction","http://tempuri.org/IPackageProductLogicService/GetPackageProductPriceByDate");		
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
		requestData.append("<tem:GetPackageProductPriceByDate>");
		requestData.append("<tem:productID>"+params.get("ProductID")+"</tem:productID>");
		requestData.append("<tem:departDate>"+params.get("DepartDate")+"</tem:departDate>");
		requestData.append("</tem:GetPackageProductPriceByDate>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
				
	}

}
