package com.aoyou.test.templates.orderservice;

import com.aoyou.test.templates.NoInputParamTemplate;

public class GetContractPath extends NoInputParamTemplate{

	@Override
	public void setURI() {
	
		uri = "http://orderdataservice.aoyou.com/orderservice.svc";
		
	}

	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/IOrderService/GetContractPath");
	}

	@Override
	public void setRequestData() {
		requestData.delete(0, requestData.length());
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:GetContractPath>");
		requestData.append("<tem:subOrderIdList>");
		requestData.append("<arr:int>1428078</arr:int>");
		requestData.append("</tem:subOrderIdList>");
		requestData.append("</tem:GetContractPath>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
		
	}

}
