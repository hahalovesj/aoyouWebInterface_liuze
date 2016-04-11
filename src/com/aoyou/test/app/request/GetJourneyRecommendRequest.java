package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetJourneyRecommendParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetJourneyRecommendRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetJourneyRecommendParamModel getJourneyRecommendParamModel=new GetJourneyRecommendParamModel();
		this.paramModel=getJourneyRecommendParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.0";
	}

}
