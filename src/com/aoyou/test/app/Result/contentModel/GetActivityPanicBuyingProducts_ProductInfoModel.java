package com.aoyou.test.app.Result.contentModel;

import java.util.List;

public class GetActivityPanicBuyingProducts_ProductInfoModel {

	//定时抢购标题名称
	public String ActivityPanicName;
	
	//目的地城市ID
	public int DestCityID;
	
	//抢购类型(1周三抢购 2周五抢购)
	public int PanicType;
	
	//产品剩余数量
	public int ProductNum;
	
	//详情
	public List<GetActivityPanicBuyingProducts_ProductViewInfoModel> ActivityProductView;
}
