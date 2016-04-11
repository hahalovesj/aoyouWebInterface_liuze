package com.aoyou.test.templates.SearchWebsiteLogicService;

import com.aoyou.test.templates.WebSerivceTemplate;


public class Search extends WebSerivceTemplate{

	@Override
	public void setURI() {
		uri = "http://searchwebsitelogicservice.aoyou.com/SearchWebsiteLogicService.svc";
	}
	@Override
	public void setHeaders() {
		headers.put("SOAPAction", "http://tempuri.org/ISearchWebsiteLogicService/Search");
	}
	@Override
	public void initParams() {
		params.put("DepartCityID", "");
		params.put("KeyWord", "");
		params.put("LabelID", "");
		params.put("ShowType", "");
		params.put("EndDepartDate", "");
		params.put("Key", "");
		params.put("Int", "");
		params.put("InterFlag", "");
		params.put("IsInstantConfirm", "");
		params.put("MaxPrice", "");
		params.put("MinPrice", "");
		params.put("StartDepartDate", "");
		params.put("SortBy", "");
		params.put("SortType", "");
		params.put("PageIndex", "");
		params.put("PageSize", "");		
	}

	@Override
	public void setRequestData() {
		requestData.delete(0, requestData.length());
		requestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:cyts=\"http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Search.WebsiteLogic.Entity\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">");
		requestData.append("<soapenv:Header/>");
		requestData.append("<soapenv:Body>");
		requestData.append("<tem:Search>");
		requestData.append("<tem:searchCondition>");
		
		if(!params.get("DepartCityID").equals("")){
			requestData.append("<cyts:DepartCityID>"+params.get("DepartCityID")+"</cyts:DepartCityID>");
		}
		if(!params.get("KeyWord").equals("")){
				requestData.append("<cyts:KeyWord>"+params.get("KeyWord")+"</cyts:KeyWord>");
		}
		if(!params.get("LabelID").equals("")){
			requestData.append("<cyts:LabelID>"+params.get("LabelID")+"</cyts:LabelID>");
		}
		if(!params.get("ShowType").equals("")){
			requestData.append("<cyts:ShowType>"+params.get("ShowType")+"</cyts:ShowType>");
		}
		
		requestData.append("</tem:searchCondition>");
		requestData.append("<tem:filterCondition>");
		
		if(!params.get("EndDepartDate").equals("")){
			requestData.append("<cyts:EndDepartDate>"+params.get("EndDepartDate")+"</cyts:EndDepartDate>");
		}
		
		requestData.append("<cyts:FilterItemList>");
		requestData.append("<arr:KeyValueOfintArrayOfintty7Ep6D1>");
		requestData.append("<arr:Key>"+params.get("Key")+"</arr:Key>");
		requestData.append("<arr:Value>");
		requestData.append("</arr:Value>");
		requestData.append("</arr:KeyValueOfintArrayOfintty7Ep6D1>");
		requestData.append("</cyts:FilterItemList>");
		
		if(!params.get("InterFlag").equals("")){
			requestData.append("<cyts:InterFlag>"+params.get("InterFlag")+"</cyts:InterFlag>");
		}else requestData.append("<cyts:InterFlag xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>");
		
		if(!params.get("IsInstantConfirm").equals("")){
			requestData.append("<cyts:IsInstantConfirm>"+params.get("IsInstantConfirm")+"</cyts:IsInstantConfirm>");
		}else requestData.append("<cyts:IsInstantConfirm xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>");
		
		if(!params.get("MaxPrice").equals("")){
			requestData.append("<cyts:MaxPrice>"+params.get("MaxPrice")+"</cyts:MaxPrice>");
		}else requestData.append("<cyts:MaxPrice xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>");
		
		if(!params.get("MinPrice").equals("")){
			requestData.append("<cyts:MinPrice>"+params.get("MinPrice")+"</cyts:MinPrice>");
		}else requestData.append("<cyts:MinPrice xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>");
		
		if(!params.get("StartDepartDate").equals("")){
			requestData.append("<cyts:StartDepartDate>"+params.get("StartDepartDate")+"</cyts:StartDepartDate>");
		}else requestData.append("<cyts:StartDepartDate xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>");
			
		requestData.append("</tem:filterCondition>");
		
		if(!params.get("SortBy").equals("")){
			requestData.append("<tem:sortBy>"+params.get("SortBy")+"</tem:sortBy>");
		}
		
		if(!params.get("SortType").equals("")){
			requestData.append("<tem:sortType>"+params.get("SortType")+"</tem:sortType>");
		}
		
		if(!params.get("PageIndex").equals("")){
			requestData.append("<tem:pageIndex>"+params.get("PageIndex")+"</tem:pageIndex>");
		}
		
		if(!params.get("PageSize").equals("")){
			requestData.append("<tem:pageSize>"+params.get("PageSize")+"</tem:pageSize>");
		}
		
		requestData.append("</tem:Search>");
		requestData.append("</soapenv:Body>");
		requestData.append("</soapenv:Envelope>");		
	}

}
