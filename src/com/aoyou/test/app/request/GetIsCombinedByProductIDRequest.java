package com.aoyou.test.app.request;

import com.aoyou.test.app.Result.model.SearchNewResult;
import com.aoyou.test.app.request.param.model.GetCombinedProductPriceCalendarParamModel;
import com.aoyou.test.base.Action;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetIsCombinedByProductIDRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		SearchNewResult searchNewResult=Action.getSearchNewResult();
		int productNum=searchNewResult.Data.ProductList.size();
		GetCombinedProductPriceCalendarParamModel getCombinedProductPriceCalendarParamModel=new GetCombinedProductPriceCalendarParamModel();
		getCombinedProductPriceCalendarParamModel.productID=searchNewResult.Data.ProductList.get(0).ProductID;
		getCombinedProductPriceCalendarParamModel.isClubmed=searchNewResult.Data.ProductList.get(0).IsClubmed;
		getCombinedProductPriceCalendarParamModel.isCombined=searchNewResult.Data.ProductList.get(0).IsCombined;
		for(int i=0;i<productNum;i++){
			//getCombinedProductPriceCalendarParamModel=new GetCombinedProductPriceCalendarParamModel();		
			if(searchNewResult.Data.ProductList.get(i).IsCombined==true){
				getCombinedProductPriceCalendarParamModel.productID=searchNewResult.Data.ProductList.get(i).ProductID;
				getCombinedProductPriceCalendarParamModel.isClubmed=searchNewResult.Data.ProductList.get(i).IsClubmed;
				getCombinedProductPriceCalendarParamModel.isCombined=searchNewResult.Data.ProductList.get(i).IsCombined;
				break;
			}			
		}
		this.paramModel=getCombinedProductPriceCalendarParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
