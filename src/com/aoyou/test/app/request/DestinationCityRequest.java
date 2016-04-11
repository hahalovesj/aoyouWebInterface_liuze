package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.DestinationCityParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class DestinationCityRequest extends RestServiceTemplate{
	
	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		DestinationCityParamModel destinationCityParamModel=new DestinationCityParamModel();
		//destinationCityParamModel.ForeignFlag=false;
		this.paramModel=(Object)destinationCityParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

	
}
