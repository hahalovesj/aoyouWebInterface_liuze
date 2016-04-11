package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetAllOrderListParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetAllOrderListRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetAllOrderListParamModel getAllOrderList=new GetAllOrderListParamModel();
		getAllOrderList.IsGetLately=true;
		getAllOrderList.PageIndex=1;
		getAllOrderList.TakeCount=20;
		getAllOrderList.OrderType="0";
		this.paramModel=getAllOrderList;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
