package com.aoyou.test.templates.orderservice;

import com.aoyou.test.templates.WebSerivceTemplate;

public class GetOrderBasicData extends WebSerivceTemplate{

	@Override
	public void setURI() {
		uri = "http://orderdataservice.aoyou.com/orderservice.svc";
	}
	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/IOrderService/GetOrderBasicData");
	}
	@Override
	public void initParams() {
		params.put("subOrderID", "");
	}

	@Override
	public void setRequestData() {
		requestData.delete(0, requestData.length());
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:GetOrderBasicData>");
		
		if(!params.get("subOrderID").equals("")){
			requestData.append("<tem:subOrderID>"+params.get("subOrderID")+"</tem:subOrderID>");
		}
		
		requestData.append("<tem:isRealTime>true</tem:isRealTime>");
		requestData.append("</tem:GetOrderBasicData>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
	}

}

