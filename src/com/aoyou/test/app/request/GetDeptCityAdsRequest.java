package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetDeptCityAdsParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetDeptCityAdsRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetDeptCityAdsParamModel getDeptCityAdsParamModel=new GetDeptCityAdsParamModel();
		//构造时，cityid已经默认为1，此处可以不做修改，也可在此处加代码进行修改
		this.paramModel=(Object)getDeptCityAdsParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
