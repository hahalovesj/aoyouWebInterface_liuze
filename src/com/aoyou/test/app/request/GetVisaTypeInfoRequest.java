package com.aoyou.test.app.request;

import com.aoyou.test.app.Result.model.GetVisaCountryListResult;
import com.aoyou.test.app.request.param.model.GetVisaTypeInfoParamModel;
import com.aoyou.test.base.Action;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.Random;

public class GetVisaTypeInfoRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetVisaCountryListResult getVisaCountryListResult=Action.getVisaCountryList();
		int size=getVisaCountryListResult.Data.size();
		int index=Random.randomCommon(0, size-1);
		GetVisaTypeInfoParamModel getVisaInfoParamModel=new GetVisaTypeInfoParamModel();
		getVisaInfoParamModel.CountryID=getVisaCountryListResult.Data.get(index).CountryID;
		this.paramModel=getVisaInfoParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.0";
	}

}
