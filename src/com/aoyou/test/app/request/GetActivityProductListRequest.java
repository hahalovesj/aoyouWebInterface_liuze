package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetActivityProductListParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetActivityProductListRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetActivityProductListParamModel getActivityProductListParamModel=new GetActivityProductListParamModel();
		getActivityProductListParamModel.PageCount=20;
		getActivityProductListParamModel.IsSoldOut=false;
		getActivityProductListParamModel.ProductType=0;
		getActivityProductListParamModel.SortBy=0;
		getActivityProductListParamModel.SalesChannel=3;
		getActivityProductListParamModel.PageIndex=1;
		getActivityProductListParamModel.destcityid=0;
		getActivityProductListParamModel.cityid=0;
		this.paramModel=(Object)getActivityProductListParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

	
}
