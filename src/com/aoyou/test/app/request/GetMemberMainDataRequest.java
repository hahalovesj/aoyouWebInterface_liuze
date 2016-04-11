package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetMemberMainDataParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetMemberMainDataRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetMemberMainDataParamModel getMemberMainDataParamModel=new GetMemberMainDataParamModel();
		getMemberMainDataParamModel.mobile="18612370907";
		this.paramModel=getMemberMainDataParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
