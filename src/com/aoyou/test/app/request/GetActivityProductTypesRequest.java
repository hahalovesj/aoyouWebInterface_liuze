package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetDeptCityAdsParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetActivityProductTypesRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetDeptCityAdsParamModel getDeptCityAdsParamModel=new GetDeptCityAdsParamModel();
		//�˽ӿ������getDeptCityAdsһֱ����ʹ������ζ��󣬹���ʱ�Ѿ�Ĭ������Ϊ1��Ҳ���ڴ���������
		this.paramModel=(Object)getDeptCityAdsParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
