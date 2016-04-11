package com.aoyou.test.app.request.param.model;

public class SearchNewParamModel {

	public SearchNew_searchConditionParamModel searchCondition=new SearchNew_searchConditionParamModel();
	
	public int pageSize=200;
	
	public int sortType=0;
	
	public SearchNew_filterConditionParamModel filterCondition=new SearchNew_filterConditionParamModel();
	
	public int sortBy=2;
	
	public int pageIndex=1;
}
