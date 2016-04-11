package com.aoyou.test.templates.SearchWebsiteLogicService;

import com.aoyou.test.templates.NoInputParamTemplate;


public class CompareProduct extends NoInputParamTemplate{
	
	@Override
	public void setURI() {
		uri = "http://searchwebsitelogicservice.aoyou.com/SearchWebsiteLogicService.svc";
		
	}

	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/ISearchWebsiteLogicService/CompareProduct");
		
	}

	@Override
	public void setRequestData() {
		int idCount = params.keySet().size();
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:CompareProduct>");
		requestData.append("<tem:productIdList>");
		if(idCount!=0){
			for(String id:params.keySet()){
				requestData.append("<arr:int>"+params.get(id)+"</arr:int>");
			}
		}
		requestData.append("</tem:productIdList>");
		requestData.append("</tem:CompareProduct>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");
		
	}
}
