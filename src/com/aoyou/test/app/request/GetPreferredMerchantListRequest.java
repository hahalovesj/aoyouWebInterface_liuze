package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetPreferredMerchantListParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetPreferredMerchantListRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetPreferredMerchantListParamModel getPreferredMerchantListParamModel=new GetPreferredMerchantListParamModel();
		getPreferredMerchantListParamModel.Country="·¨¹ú";
		getPreferredMerchantListParamModel.City="°ÍÀè";
		getPreferredMerchantListParamModel.Type="¹ºÎï";
		getPreferredMerchantListParamModel.pageCount=20;
		getPreferredMerchantListParamModel.pageIndex=1;
		this.paramModel=getPreferredMerchantListParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.0";
	}

}
