package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.MessageIsShowRedPointParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class MessageIsShowRedPointRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		MessageIsShowRedPointParamModel messageIsShowRedPointParamModel=new MessageIsShowRedPointParamModel();
		messageIsShowRedPointParamModel.readType=1;
		this.paramModel=(Object)messageIsShowRedPointParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
