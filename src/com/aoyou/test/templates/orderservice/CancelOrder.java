package com.aoyou.test.templates.orderservice;

import com.aoyou.test.templates.WebSerivceTemplate;

public class CancelOrder extends WebSerivceTemplate{

	@Override
	public void setURI() {
		uri = "http://orderdataservice.aoyou.com/orderservice.svc";
	}
	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/IOrderService/CancelOrder");
	}
	@Override
	public void initParams() {
		params.put("MainOrderID", "");
		params.put("SubOrderID", "");
		params.put("OrderNum", "");
		params.put("OrderType", "");
		params.put("SubOrderType", "");
		params.put("OrderNO", "");
		params.put("InputDate", "");
	}

	@Override
	public void setRequestData() {
		requestData.delete(0, requestData.length());
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:cyts=\"http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:CancelOrder>");
		
		if(!params.get("MainOrderID").equals("")){
			requestData.append("<tem:MainOrderID>"+params.get("MainOrderID")+"</tem:MainOrderID>");
		}
		if(!params.get("SubOrderID").equals("")){
			requestData.append("<tem:SubOrderID>"+params.get("SubOrderID")+"</tem:SubOrderID>");
		}
		if(!params.get("OrderNum").equals("")){
			requestData.append("<tem:OrderNum>"+params.get("OrderNum")+"</tem:OrderNum>");
		}
		
		requestData.append("<tem:CancelDetails>≤‚ ‘∂©µ•</tem:CancelDetails>");
		
		if(!params.get("OrderType").equals("")){
			requestData.append("<tem:OrderType>"+params.get("OrderType")+"</tem:OrderType>");
		}
		if(!params.get("SubOrderType").equals("")){
			requestData.append("<tem:SubOrderType>"+params.get("SubOrderType")+"</tem:SubOrderType>");
		}
		if(!params.get("OrderNO").equals("")){
			requestData.append("<tem:OrderNO>"+params.get("OrderNO")+"</tem:OrderNO>");
		}
		if(!params.get("InputDate").equals("")){
			requestData.append("<tem:InputDate>"+params.get("InputDate")+"</tem:InputDate>");
		}
		
		requestData.append("<tem:InputDept>019504</tem:InputDept>");
		requestData.append("<tem:InputUser>2855</tem:InputUser>");
		requestData.append("</tem:CancelOrder>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
	}

}

