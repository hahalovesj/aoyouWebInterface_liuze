package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetCouponsInfoByUserIDParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetCouponsInfoByUserIDRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetCouponsInfoByUserIDParamModel getCouponsInfoByUserIDParamModel=new GetCouponsInfoByUserIDParamModel();
		this.paramModel=getCouponsInfoByUserIDParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

	
}
