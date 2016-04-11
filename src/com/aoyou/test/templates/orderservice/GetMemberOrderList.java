package com.aoyou.test.templates.orderservice;

import com.aoyou.test.templates.WebSerivceTemplate;

public class GetMemberOrderList extends WebSerivceTemplate{

	@Override
	public void setURI() {
		uri = "http://orderdataservice.aoyou.com/orderservice.svc";
	}
	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/IOrderService/GetMemberOrderList");
	}
	@Override
	public void initParams() {
		params.put("MemberID", "");
		params.put("PageCount", "");
		params.put("OrderType", "");
		
	}

	@Override
	public void setRequestData() {
		requestData.delete(0, requestData.length());
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:GetMemberOrderList>");
	
		if(!params.get("MemberID").equals("")){
			requestData.append("<tem:MemberID>"+params.get("MemberID")+"</tem:MemberID>");
		}
		if(!params.get("PageCount").equals("")){
				requestData.append("<tem:PageCount>"+params.get("PageCount")+"</tem:PageCount>");
		}
		if(!params.get("OrderType").equals("")){
			requestData.append("<tem:OrderType>"+params.get("OrderType")+"</tem:OrderType>");
		}
		
		requestData.append("</tem:GetMemberOrderList>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");		
	}

}

