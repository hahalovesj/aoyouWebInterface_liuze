package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetIndexRecommendProductParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetIndexRecommendProductRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetIndexRecommendProductParamModel getIndexRecommendProductParamModel=new GetIndexRecommendProductParamModel();
		getIndexRecommendProductParamModel.AppSiteId=1;
		this.paramModel=(Object)getIndexRecommendProductParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
