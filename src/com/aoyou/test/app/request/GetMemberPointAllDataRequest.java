package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetMemberPointAllDataParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetMemberPointAllDataRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetMemberPointAllDataParamModel getMemberPointAllData=new GetMemberPointAllDataParamModel();
		this.paramModel=getMemberPointAllData;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
