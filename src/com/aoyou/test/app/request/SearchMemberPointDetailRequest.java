package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.SearchMemberPointDetailParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class SearchMemberPointDetailRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		this.paramModel=new SearchMemberPointDetailParamModel();
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
