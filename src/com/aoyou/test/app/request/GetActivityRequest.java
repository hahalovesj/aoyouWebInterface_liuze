package com.aoyou.test.app.request;

import com.aoyou.test.app.Result.model.GetActivityProductListResult;
import com.aoyou.test.app.request.param.model.ActivityProductIndexParamModel;
import com.aoyou.test.base.Action;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.Random;

public class GetActivityRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetActivityProductListResult getActivityProductListResult=Action.getActivityProductListResult();
		int size=getActivityProductListResult.Data.ActivityProducts.size();
		int index=Random.randomCommon(0,size-1);
		ActivityProductIndexParamModel activityProductIndexParamModel=new ActivityProductIndexParamModel();
		activityProductIndexParamModel.ActivityID=getActivityProductListResult.Data.ActivityProducts.get(index).ActivityID;
		this.paramModel=activityProductIndexParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.0";
	}

}
