package com.aoyou.test.app.request;

import com.aoyou.test.app.Result.model.GetProductSpecListResult;
import com.aoyou.test.app.request.param.model.GetProductSpecParamModel;
import com.aoyou.test.base.Action;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.Random;

public class GetProductSpecRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetProductSpecListResult getProductSpecListResult=new GetProductSpecListResult();
		getProductSpecListResult=Action.getProductSpecList();
		int size=getProductSpecListResult.Data.size();
		int index=Random.randomCommon(0, size-1);
		GetProductSpecParamModel getProductSpecParamModel=new GetProductSpecParamModel();
		getProductSpecParamModel.ProMoID=getProductSpecListResult.Data.get(index).Pro_Mo_ID;
		getProductSpecParamModel.ProType=getProductSpecListResult.Data.get(index).Pro_Mo_Type;
		this.paramModel=getProductSpecParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.0";
	}

}
