package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.DestinationCityForAppIndexParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class DestinationCityForAppIndexRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		DestinationCityForAppIndexParamModel destinationCityForAppIndexParamModel=new DestinationCityForAppIndexParamModel();		
		destinationCityForAppIndexParamModel.ForeignFlag=true;
		this.paramModel=(Object)destinationCityForAppIndexParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
