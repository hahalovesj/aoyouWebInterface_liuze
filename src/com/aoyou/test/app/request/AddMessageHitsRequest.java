package com.aoyou.test.app.request;

import java.util.Map;

import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.app.request.param.model.AddMessageHitsParamModel;
import com.aoyou.test.base.*;

public class AddMessageHitsRequest extends RestServiceTemplate{
	
	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		AddMessageHitsParamModel addMessageHitsParam=new AddMessageHitsParamModel();
		@SuppressWarnings("rawtypes")
		Map map=Action.getNewMessageInfo();
		if(map!=null){
			for(Object key:map.keySet()){
				addMessageHitsParam.ProMoID=(int)key;
				addMessageHitsParam.ProType=(int)map.get(key);
				break;
			}
		}		
		this.paramModel=(Object)addMessageHitsParam;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}
}
