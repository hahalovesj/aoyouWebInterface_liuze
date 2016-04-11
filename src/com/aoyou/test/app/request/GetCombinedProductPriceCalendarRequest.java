package com.aoyou.test.app.request;

import com.aoyou.test.app.Result.model.SearchNewResult;
import com.aoyou.test.app.request.param.model.GetCombinedProductPriceCalendarParamModel;
import com.aoyou.test.base.Action;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.Random;

public class GetCombinedProductPriceCalendarRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		SearchNewResult searchNewResult=Action.getSearchNewResult();
		int productNum=searchNewResult.Data.ProductList.size();
		int productIndex=0;
		if(productNum>0){
			productIndex=Random.randomCommon(0,productNum-1,1)[0];
		}
		int productId=searchNewResult.Data.ProductList.get(productIndex).ProductID;
		GetCombinedProductPriceCalendarParamModel getCombinedProductPriceCalendarParamModel=new GetCombinedProductPriceCalendarParamModel();
		getCombinedProductPriceCalendarParamModel.productID=productId;
		this.paramModel=getCombinedProductPriceCalendarParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
