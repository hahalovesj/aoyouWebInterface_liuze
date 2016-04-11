package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.ProductSearchIndexParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class ProductSearchIndexRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		ProductSearchIndexParamModel productSearchIndexParamModel=new ProductSearchIndexParamModel();
		productSearchIndexParamModel.DepartCityID=1;
		this.paramModel=productSearchIndexParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
