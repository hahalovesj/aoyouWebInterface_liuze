package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetDeptCityAdsParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetDeptCityAdsRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetDeptCityAdsParamModel getDeptCityAdsParamModel=new GetDeptCityAdsParamModel();
		//����ʱ��cityid�Ѿ�Ĭ��Ϊ1���˴����Բ����޸ģ�Ҳ���ڴ˴��Ӵ�������޸�
		this.paramModel=(Object)getDeptCityAdsParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
