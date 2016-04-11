package com.aoyou.test.templates.orderservice;

import com.aoyou.test.templates.WebSerivceTemplate;

public class Get_FlightOrder_Detail extends WebSerivceTemplate{

	@Override
	public void setURI() {
		uri = "http://orderdataservice.aoyou.com/orderservice.svc";
	}
	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/IOrderService/Get_FlightOrder_Detail");
	}
	@Override
	public void initParams() {
		params.put("SubOrderID", "");
	}

	@Override
	public void setRequestData() {
		requestData.delete(0, requestData.length());
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:cyts=\"http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:Get_FlightOrder_Detail>");
		requestData.append("<tem:condition>");
	
		if(!params.get("SubOrderID").equals("")){
			requestData.append("<cyts:SubOrderID>"+params.get("SubOrderID")+"</cyts:SubOrderID>");
		}
		
		requestData.append("</tem:condition>");
		requestData.append("</tem:Get_FlightOrder_Detail>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
	}

}

