package com.aoyou.test.templates.orderservice;

import com.aoyou.test.templates.WebSerivceTemplate;

public class ValidMemberBooking extends WebSerivceTemplate{

	@Override
	public void setURI() {
		uri = "http://orderdataservice.aoyou.com/orderservice.svc";
	}
	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/IOrderService/ValidMemberBooking");
	}
	@Override
	public void initParams() {
		params.put("memberID", "");
		params.put("mainOrderID", "");
	}

	@Override
	public void setRequestData() {
		requestData.delete(0, requestData.length());
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:ValidMemberBooking>");
		
		if(!params.get("memberID").equals("")){
			requestData.append("<tem:memberID>"+params.get("memberID")+"</tem:memberID>");
		}
		if(!params.get("mainOrderID").equals("")){
				requestData.append("<tem:mainOrderID>"+params.get("mainOrderID")+"</tem:mainOrderID>");
		}
		
		requestData.append("</tem:ValidMemberBooking>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
	}

}

