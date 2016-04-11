package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetDeptCityAdsParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetActivityProductTypesRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetDeptCityAdsParamModel getDeptCityAdsParamModel=new GetDeptCityAdsParamModel();
		//此接口入参与getDeptCityAds一直，故使用起入参对象，构造时已经默认设置为1，也可在此重新设置
		this.paramModel=(Object)getDeptCityAdsParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
