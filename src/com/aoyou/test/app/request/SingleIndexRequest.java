package com.aoyou.test.app.request;

import com.aoyou.test.app.Result.model.SearchNewResult;
import com.aoyou.test.app.request.param.model.SingleIndexParamModel;
import com.aoyou.test.base.Action;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.Random;

public class SingleIndexRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		SearchNewResult searchNewResult=Action.getProductList();
		SingleIndexParamModel singleIndexParamModel=new SingleIndexParamModel();
		int size=searchNewResult.Data.ProductList.size();
		int index=Random.randomCommon(0, size-1);
		singleIndexParamModel.productID=searchNewResult.Data.ProductList.get(index).ProductID;
		this.paramModel=singleIndexParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.0";
	}

}
