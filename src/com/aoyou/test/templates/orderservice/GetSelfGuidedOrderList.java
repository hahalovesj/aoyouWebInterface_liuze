package com.aoyou.test.templates.orderservice;

import com.aoyou.test.templates.WebSerivceTemplate;

public class GetSelfGuidedOrderList extends WebSerivceTemplate{

	@Override
	public void setURI() {
		uri = "http://orderdataservice.aoyou.com/orderservice.svc";
	}
	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/IOrderService/GetSelfGuidedOrderList");
	}
	@Override
	public void initParams() {
		params.put("userID", "");
		params.put("orderType", "");
	}

	@Override
	public void setRequestData() {
		requestData.delete(0, requestData.length());
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:cyts=\"http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:GetSelfGuidedOrderList>");
		
		if(!params.get("userID").equals("")){
			requestData.append("<tem:userID>"+params.get("userID")+"</tem:userID>");
		}
		
		if(!params.get("orderType").equals("")){
			requestData.append("<tem:orderType>"+params.get("orderType")+"</tem:orderType>");
		}
	
		requestData.append("</tem:GetSelfGuidedOrderList>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
	}

}

