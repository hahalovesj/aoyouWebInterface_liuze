package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.SearchNewParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class SearchNewRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		SearchNewParamModel searchNewParamModel=new SearchNewParamModel();
		this.paramModel=(Object)searchNewParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
