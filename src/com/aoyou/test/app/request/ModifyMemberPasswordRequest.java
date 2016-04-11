package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.ModifyMemberPasswordParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class ModifyMemberPasswordRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		ModifyMemberPasswordParamModel modifyMemberPasswordParamModel=new ModifyMemberPasswordParamModel();
		modifyMemberPasswordParamModel.oldpassword="Fiona19870907";
		modifyMemberPasswordParamModel.newpassword="Fiona19870907";
		this.paramModel=modifyMemberPasswordParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
