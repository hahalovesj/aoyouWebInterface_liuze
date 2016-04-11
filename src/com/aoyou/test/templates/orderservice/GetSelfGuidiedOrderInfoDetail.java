package com.aoyou.test.templates.orderservice;

import com.aoyou.test.templates.WebSerivceTemplate;

public class GetSelfGuidiedOrderInfoDetail extends WebSerivceTemplate{

	@Override
	public void setURI() {
		uri = "http://orderdataservice.aoyou.com/orderservice.svc";
	}
	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/IOrderService/GetSelfGuidiedOrderInfoDetail");
	}
	@Override
	public void initParams() {
		params.put("orderNo", "");
		params.put("customerId", "");
	}

	@Override
	public void setRequestData() {
		requestData.delete(0, requestData.length());
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:cyts=\"http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:GetSelfGuidiedOrderInfoDetail>");
		
		if(!params.get("orderNo").equals("")){
			requestData.append("<tem:orderNo>"+params.get("orderNo")+"</tem:orderNo>");
		}
		if(!params.get("customerId").equals("")){
			requestData.append("<tem:customerId>"+params.get("customerId")+"</tem:customerId>");
		}
		
		requestData.append("</tem:GetSelfGuidiedOrderInfoDetail>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
	}

}

