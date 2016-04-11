package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.ModifyMemebrInfoParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class ModifyMemebrInfoRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		ModifyMemebrInfoParamModel modifyMemebrInfoParamModel=new ModifyMemebrInfoParamModel();
		modifyMemebrInfoParamModel.name="¿Óœ»…˙";
		this.paramModel=modifyMemebrInfoParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
