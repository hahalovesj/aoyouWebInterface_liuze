package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetNewActivityPanicBuyingProductsParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetNewActivityPanicBuyingProductsRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetNewActivityPanicBuyingProductsParamModel getNewActivityPanicBuyingProductsParamModel=new GetNewActivityPanicBuyingProductsParamModel();
		getNewActivityPanicBuyingProductsParamModel.CityID=1;
		this.paramModel=getNewActivityPanicBuyingProductsParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
