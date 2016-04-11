package com.aoyou.test.templates.orderservice;

import com.aoyou.test.templates.WebSerivceTemplate;

public class GetFlightOrderList extends WebSerivceTemplate{

	@Override
	public void setURI() {
		uri = "http://orderdataservice.aoyou.com/orderservice.svc";
	}
	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/IOrderService/GetFlightOrderList");
	}
	@Override
	public void initParams() {
		params.put("MemberID", "");
		params.put("PageIndex", "");
		params.put("PageCount", "");
		
	}

	@Override
	public void setRequestData() {
		requestData.delete(0, requestData.length());
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:GetFlightOrderList>");
	
		if(!params.get("MemberID").equals("")){
			requestData.append("<tem:MemberID>"+params.get("MemberID")+"</tem:MemberID>");
		}
		if(!params.get("PageIndex").equals("")){
				requestData.append("<tem:PageIndex>"+params.get("PageIndex")+"</tem:PageIndex>");
		}
		if(!params.get("PageCount").equals("")){
			requestData.append("<tem:PageCount>"+params.get("PageCount")+"</tem:PageCount>");
		}
		
		requestData.append("</tem:GetFlightOrderList>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");		
	}

}

