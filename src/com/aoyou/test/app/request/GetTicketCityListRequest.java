package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetTicketCityListParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetTicketCityListRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetTicketCityListParamModel getTicketCityListParamModel=new GetTicketCityListParamModel();
		getTicketCityListParamModel.SortType=2;
		getTicketCityListParamModel.SortMode=0;
		getTicketCityListParamModel.IsNowDay=false;
		getTicketCityListParamModel.Key_Word="±±¾©";
		this.paramModel=(Object)getTicketCityListParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
