package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.SearchParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class TicketSearchRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		SearchParamModel searchParamModel=new SearchParamModel();
		searchParamModel.SortType=2;
		searchParamModel.PageIndex=1;
		searchParamModel.RowNum=10;
		searchParamModel.SortMode=0;
		searchParamModel.IsNowDay=false;
		searchParamModel.Key_Word="±±¾©";
		this.paramModel=searchParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.0";
	}

}
