package com.aoyou.test.templates.orderservice;

import com.aoyou.test.templates.WebSerivceTemplate;

public class GetTouristOrderListByType extends WebSerivceTemplate{

	@Override
	public void setURI() {
		uri = "http://orderdataservice.aoyou.com/orderservice.svc";
	}
	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/IOrderService/GetTouristOrderListByType");
	}
	@Override
	public void initParams() {
		params.put("MemberID", "");
		params.put("PageIndex", "");
		params.put("PageCount", "");
		params.put("orderType", "");
		params.put("orderSubType", "");
	}

	@Override
	public void setRequestData() {
		requestData.delete(0, requestData.length());
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:cyts=\"http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:GetTouristOrderListByType>");
		
		if(!params.get("MemberID").equals("")){
			requestData.append("<tem:MemberID>"+params.get("MemberID")+"</tem:MemberID>");
		}
		if(!params.get("PageIndex").equals("")){
				requestData.append("<tem:PageIndex>"+params.get("PageIndex")+"</tem:PageIndex>");
		}
		if(!params.get("PageCount").equals("")){
			requestData.append("<tem:PageCount>"+params.get("PageCount")+"</tem:PageCount>");
		}
		if(!params.get("orderType").equals("")){
			requestData.append("<tem:orderType>"+params.get("orderType")+"</tem:orderType>");
		}
		if(!params.get("orderSubType").equals("")){
			requestData.append("<tem:orderSubType>"+params.get("orderSubType")+"</tem:orderSubType>");
		}
		
		requestData.append("</tem:GetTouristOrderListByType>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
	}

}

