package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetTermsParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetTermsRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetTermsParamModel getTermsParamModel=new GetTermsParamModel();
		getTermsParamModel.takeTermCount=3;
		getTermsParamModel.lastTakedTermNumber=0;
		this.paramModel=(Object)getTermsParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
