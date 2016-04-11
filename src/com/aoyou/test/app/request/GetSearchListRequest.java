package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetSearchListParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetSearchListRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetSearchListParamModel getSearchListParamModel=new GetSearchListParamModel();
		getSearchListParamModel.Keyword="1";
		getSearchListParamModel.PageNo=1;
		getSearchListParamModel.PageSize=1;
		getSearchListParamModel.SrchFid="37";
		this.paramModel=(Object)getSearchListParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
