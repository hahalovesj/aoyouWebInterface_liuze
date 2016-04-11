package com.aoyou.test.app.request;

import com.aoyou.test.app.Result.model.GetVisaTypeInfoResult;
import com.aoyou.test.app.request.param.model.GetVisaInfoParamModel;
import com.aoyou.test.base.Action;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.Random;

public class GetVisaInfoRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetVisaTypeInfoResult getVisaTypeInfoResult=Action.getVisaTypeInfo();
		int size=getVisaTypeInfoResult.Data.size();
		int index=Random.randomCommon(0, size-1);
		GetVisaInfoParamModel getVisaInfoParamModel=new GetVisaInfoParamModel();
		getVisaInfoParamModel.CountryID=getVisaTypeInfoResult.Data.get(index).CountryID;
		getVisaInfoParamModel.VisaTypeID=getVisaTypeInfoResult.Data.get(index).VisaTypeID;
		this.paramModel=getVisaInfoParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.0";
	}

}
