package com.aoyou.test.app.request;

import com.aoyou.test.app.Result.model.GetPreferredMerchantListResult;
import com.aoyou.test.app.request.param.model.GetPreferredMerchantParamModel;
import com.aoyou.test.base.Action;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.Random;

public class GetPreferredMerchantRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetPreferredMerchantListResult getPreferredMerchantListResult=Action.getPreferredMerchantList();
		int size=getPreferredMerchantListResult.Data.size();
		int index=Random.randomCommon(0, size-1);
		GetPreferredMerchantParamModel getPreferredMerchantParamModel=new GetPreferredMerchantParamModel();
		getPreferredMerchantParamModel.PMID=getPreferredMerchantListResult.Data.get(index).PM_ID;
		this.paramModel=getPreferredMerchantParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.0";
	}

}
