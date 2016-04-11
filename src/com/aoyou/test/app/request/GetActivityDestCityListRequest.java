package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetActivityDestCityListParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetActivityDestCityListRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetActivityDestCityListParamModel getActivityDestCityListParamModel=new GetActivityDestCityListParamModel();
		this.paramModel=(Object)getActivityDestCityListParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
