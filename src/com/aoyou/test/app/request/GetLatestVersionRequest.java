package com.aoyou.test.app.request;

import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.app.request.param.model.GetLatestVersionParamModel;

public class GetLatestVersionRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetLatestVersionParamModel getLatestVersionParamModel=new GetLatestVersionParamModel();
		getLatestVersionParamModel.TerminalId="195001";
		this.paramModel=(Object)getLatestVersionParamModel;
	}
	
	@Override
	public void setMethodVersion(){
		this.version="app3.0";
	}
}
