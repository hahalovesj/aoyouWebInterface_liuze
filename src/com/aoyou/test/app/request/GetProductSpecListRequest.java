package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetProductSpecListParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetProductSpecListRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetProductSpecListParamModel getProductSpecListParamModel=new GetProductSpecListParamModel();
		getProductSpecListParamModel.Count=200;
		getProductSpecListParamModel.PageSize=1;
		getProductSpecListParamModel.ProMoType=0;
		this.paramModel=getProductSpecListParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.0";
	}

}
