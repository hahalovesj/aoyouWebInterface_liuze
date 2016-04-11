package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetMemberParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetMemberRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetMemberParamModel getMemberParamModel=new GetMemberParamModel();
		getMemberParamModel.Email="570145929@qq.com";
		getMemberParamModel.Mobile="18612370907";
		this.paramModel=getMemberParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
