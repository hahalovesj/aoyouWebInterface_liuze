package com.aoyou.test.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.*;
import com.aoyou.test.app.Result.model.GetActivityProductListResult;
import com.aoyou.test.app.Result.model.GetMessageInfoResult;
import com.aoyou.test.app.Result.model.GetPreferredMerchantListResult;
import com.aoyou.test.app.Result.model.GetProductSpecListResult;
import com.aoyou.test.app.Result.model.GetTopicListResult;
import com.aoyou.test.app.Result.model.GetVisaCountryListResult;
import com.aoyou.test.app.Result.model.GetVisaTypeInfoResult;
import com.aoyou.test.app.Result.model.SearchNewResult;
import com.aoyou.test.app.Result.model.TicketSearchResult;
import com.aoyou.test.app.Result.model.TicketSelectResult;
import com.aoyou.test.app.request.GetActivityProductListRequest;
import com.aoyou.test.app.request.GetNewMessageInfoRequest;
import com.aoyou.test.app.request.GetPreferredMerchantListRequest;
import com.aoyou.test.app.request.GetProductSpecListRequest;
import com.aoyou.test.app.request.GetTopicListRequest;
import com.aoyou.test.app.request.GetVisaCountryListRequest;
import com.aoyou.test.app.request.GetVisaTypeInfoRequest;
import com.aoyou.test.app.request.SearchNewRequest;
import com.aoyou.test.app.request.TicketSearchRequest;
import com.aoyou.test.app.request.TicketSelectRequest;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.templates.SearchWebsiteLogicService.Search;
import com.aoyou.test.templates.orderservice.CancelOrder;
import com.aoyou.test.templates.orderservice.Get_TouristOrder_Detail;
import com.aoyou.test.util.HandleDate;
import com.aoyou.test.util.Log;
import com.aoyou.test.util.ParseXmlString;
import com.aoyou.test.util.Random;

public class Action {
	
	public static List<String> getProductID(int number,String type){
		List<String> productID = new ArrayList<String>();
		ParseXmlString px = new ParseXmlString();
		String responseString = null;
		SetTest test = new Search();
		test.setParams("Key", "1");
		if(!type.equals("0")){
		test.setParams("ShowType", type);
		}
		test.sendPost();
		
		if(test.getStatus()==200){		
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Search.WebsiteLogic.Entity");
			px.Load(responseString);		
			int[] index = Random.randomCommon(0, px.getElementsText("//a:ProductID").size()-1, number);
			for(int i:index){
				productID.add(px.getElementsText("//a:ProductID").get(i));
			}
		}else throw new InterfaceCallException("Search�ӿڵ���ʧ�ܣ�"+test.getStatus());
		
		return productID;
	}
	

	public static Map<String,String> getTourDetail(String MainOrderID){
		Map<String,String> map = new HashMap<String,String>();
		ParseXmlString px = new ParseXmlString();
		String responseString = null;
		SetTest test = new Get_TouristOrder_Detail();
		test.setParams("MainOrderID",MainOrderID);		
		test.setParams("MemberID", "11266537");
		test.sendPost();
		if(test.getStatus()==200){
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Data.Order.Entity");
			px.Load(responseString);
			map.put("MainOrderID", MainOrderID);
			map.put("SubOrderID", px.getElementText("//a:SubOrderID"));
			map.put("OrderNum", px.getElementText("//a:OrderNum"));
			map.put("OrderType", px.getElementText("//a:OrderType"));
			map.put("SubOrderType", px.getElementText("//a:OrderSubType"));
			map.put("OrderNO", px.getElementText("//a:OrderNO"));
			
		}else throw new InterfaceCallException("Get_TouristOrder_Detail�ӿڵ���ʧ�ܣ�"+test.getStatus());
		
		return map;
	}
	
	public static void CancelOrder(Map<String,String> map) throws Exception{
		
		String responseString = null;
		SetTest test = new CancelOrder();
		test.setParams("MainOrderID",map.get("MainOrderID"));
		test.setParams("SubOrderID", map.get("SubOrderID"));
		test.setParams("OrderNum",map.get("OrderNum"));
		test.setParams("OrderType",map.get("OrderType"));
		test.setParams("SubOrderType",map.get("SubOrderType"));
		test.setParams("OrderNO",map.get("OrderNO"));
		test.setParams("InputDate",HandleDate.getNowDayString());
		boolean flag=true;
		int count = 0;
		
		while(flag){
			flag = false;
			if(count<3){
    	
		test.sendPost();
		
		if(test.getStatus()==200){
			responseString = test.getResponseString();
			
			if(!responseString.contains("<CancelOrderResult>true</CancelOrderResult>")){
				Log.logWarn("ǩ֤����ȡ��ʧ��"+count+"��");
				flag = true;	
			}  
	}	
    		
    }
			count++;
			
			}

		if(count>=3){
			throw new Exception("ǩ֤������������ȡ��ʧ��!");
			
		}
	}
	public static String getSingleProductID(String type){
		String productID = null;
		ParseXmlString px = new ParseXmlString();
		String responseString = null;
		SetTest test = new Search();
		test.setParams("Key", "1");
		if(!type.equals("0")){
		test.setParams("ShowType", type);
		}
		test.sendPost();
		
		if(test.getStatus()==200){		
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Search.WebsiteLogic.Entity");
			px.Load(responseString);
			int index = (int)(Math.random()*px.getElementsText("//a:ProductID").size());
			productID=px.getElementsText("//a:ProductID").get(index);
		
		}else throw new InterfaceCallException("Search�ӿڵ���ʧ�ܣ�"+test.getStatus());
		
		return productID;
		
	}
	
	/**
	 * ���ָ�����͵������в�Ʒid 
	 * @param type 0Ϊ��׼�����в�Ʒ��1Ϊ�����Ʋ�Ʒ��2Ϊclubmed��Ʒ
	 */
	public static String getPackageProductID(int type){
	
	List<String> allProductID = null;
	List<String> combinedID = null;
//	List<String> clubmedID = null;
	int index;
	String id = null;
	ParseXmlString px = new ParseXmlString();
	
	SetTest test = new Search();
	test.setParams("Key", "1");
	test.setParams("ShowType", "1");
	test.setParams("PageSize","3000");
	test.setParams("PageIndex","1");
	test.sendPost();
	System.out.println(test.getResponseString());
	
	if(test.getStatus()==200){
		px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Search.WebsiteLogic.Entity");
		px.Load(test.getResponseString());
		allProductID = px.getElementsText("//a:ProductID");
		combinedID = px.getElementsText("//a:IsCombined[contains(text(),'true')]/../a:ProductID");
//		clubmedID = px.getElementsText("//a:IsClubmed[contains(text(),'true')]/../a:ProductID");
		
		if(type==1){
			index = Random.randomCommon(0,(combinedID.size()-1));
			id = combinedID.get(index);
			
		}
//		else if(type==2){
//			index = Random.randomCommon(0,(clubmedID.size()-1));
//			id = clubmedID.get(index);
//			
//		}
		else if(type==0){
			allProductID.removeAll(combinedID);
//			allProductID.removeAll(clubmedID);
			index = Random.randomCommon(0,(allProductID.size()-1));
			id = allProductID.get(index);
		}else{System.out.println("��Ʒ���Ͳ�������type 0Ϊ��׼�����в�Ʒ��1Ϊ�����Ʋ�Ʒ��2Ϊclubmed��Ʒ");};
		
	}else throw new InterfaceCallException("Search�ӿڵ���ʧ�ܣ�"+test.getStatus());

	return id;
	
	}
	
	/**��ȡ��Ϣ��Ϣ�б�
	 * @return �ش���Ϣ�б���Ϣ��������ϢID����Ϣ����**/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map getNewMessageInfo(){
		Map map=new HashMap();
		SetTest test=new GetNewMessageInfoRequest();
		test.sendPost();
		String jsonString=test.getResponseString().replace("\\\\\\\\", "\\\\");
		Gson gson=new Gson();
		GetMessageInfoResult getMessageInfoResult=gson.fromJson(jsonString, GetMessageInfoResult.class);
		int length=getMessageInfoResult.Data.NewMessageList.size();
		for(int i=0;i<length;){
			map.put(getMessageInfoResult.Data.NewMessageList.get(i).Message_id, getMessageInfoResult.Data.NewMessageList.get(i).Message_type);
			break;
		}		
		return map;
	}
	
	/**��ȡtopicList**/
	public static GetTopicListResult getTopicIdList(){
		GetTopicListResult getTopicListResult=new GetTopicListResult();
		SetTest test=new GetTopicListRequest();
		test.sendPost();
		Gson gson=new Gson();
		String jsonString=test.getResponseString();
		getTopicListResult=gson.fromJson(jsonString, GetTopicListResult.class);
		return getTopicListResult;
	}
	
	/**��ȡ��Ʒ�б���� **/
	public static SearchNewResult getSearchNewResult(){
		
		SetTest test=new SearchNewRequest();
		test.sendPost();		
		SearchNewResult searchNewResult=(SearchNewResult) ((RestServiceTemplate)test).getResponseMode(); 
		return searchNewResult;
	}
	
	/**��ȡ�����б�**/
	public static TicketSearchResult getTicketSearchResult(){
		TicketSearchResult ticketSearchResult=null;
		
		SetTest test=new TicketSearchRequest();
		test.sendPost();
		ticketSearchResult=(TicketSearchResult) ((RestServiceTemplate) test).getResponseMode();
		
		return ticketSearchResult;
	}
	
	/**��ȡ�����µ���Ʊ��Ϣ**/
	public static TicketSelectResult getTicketSelectResult(){
		
		TicketSelectResult ticketSelectResult=null;
		
		SetTest test=new TicketSelectRequest();
		test.sendPost();
		//System.out.println(test.getResponseString());
		ticketSelectResult=(TicketSelectResult) ((RestServiceTemplate) test).getResponseMode();
		
		return ticketSelectResult;
	}
	
	/**��ȡ���Żݲ�Ʒ�б�**/
	public static GetActivityProductListResult getActivityProductListResult(){
		GetActivityProductListResult getActivityProductListResult=null;
		SetTest test=new GetActivityProductListRequest();
		test.sendPost();
		getActivityProductListResult=(GetActivityProductListResult) ((RestServiceTemplate) test).getResponseMode();
		return getActivityProductListResult;
	}
	
	/**��ȡ��Ʒ�б�**/
	public static SearchNewResult getProductList(){
		SearchNewResult searchNewResult=null;
		SetTest test=new SearchNewRequest();
		test.sendPost();
		searchNewResult=(SearchNewResult) ((RestServiceTemplate) test).getResponseMode();
		return searchNewResult;
	}
	
	/**��ȡǩ֤���Һ͵����б�**/
	public static GetVisaCountryListResult getVisaCountryList(){
		GetVisaCountryListResult result=null;
		SetTest test=new GetVisaCountryListRequest();
		test.sendPost();
		result=(GetVisaCountryListResult) ((RestServiceTemplate) test).getResponseMode();
		return result;
	}
	
	/**��ȡǩ֤�����б�**/
	public static GetVisaTypeInfoResult getVisaTypeInfo(){
		GetVisaTypeInfoResult getVisaTypeInfoResult=null;
		SetTest test=new GetVisaTypeInfoRequest();
		test.sendPost();
		getVisaTypeInfoResult=(GetVisaTypeInfoResult) ((RestServiceTemplate) test).getResponseMode();
		return getVisaTypeInfoResult;
	}
	
	/**��ȡ�Ƽ���Ʒ�б�**/
	public static GetProductSpecListResult getProductSpecList(){
		GetProductSpecListResult getProductSpecListResult=null;
		SetTest test=new GetProductSpecListRequest();
		test.sendPost();
		getProductSpecListResult=(GetProductSpecListResult) ((RestServiceTemplate) test).getResponseMode();
		return getProductSpecListResult;
	}
	
	/**��ȡ��ѡ�̻��б�**/
	public static GetPreferredMerchantListResult getPreferredMerchantList(){
		GetPreferredMerchantListResult getPreferredMerchantListResult=null;
		SetTest test=new GetPreferredMerchantListRequest();
		test.sendPost();
		getPreferredMerchantListResult=(GetPreferredMerchantListResult) ((RestServiceTemplate) test).getResponseMode();
		return getPreferredMerchantListResult;
	}
}
