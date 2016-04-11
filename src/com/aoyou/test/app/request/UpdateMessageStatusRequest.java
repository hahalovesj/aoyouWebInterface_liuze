package com.aoyou.test.app.request;

import java.util.Map;

import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.app.request.param.model.UpdateMessageStatusParamModel;
import com.aoyou.test.base.*;



public class UpdateMessageStatusRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		UpdateMessageStatusParamModel updateMessageStatusParamModel=new UpdateMessageStatusParamModel();
		@SuppressWarnings("rawtypes")
		Map map=Action.getNewMessageInfo();
		if(map!=null){
			for(Object key:map.keySet()){
				updateMessageStatusParamModel.MessageId=(int)map.get(key);
				break;
			}			
		}
		this.paramModel=(Object)updateMessageStatusParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
