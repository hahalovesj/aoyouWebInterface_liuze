package com.aoyou.test.app.Result.contentModel;

import java.util.ArrayList;

public class DestinationCity_CityInfoViewModel {

	//版本号
	public String Ver;
	
	//国内/境外(热门目的地名称)
	public String GroupName;
	
	//按分类返回目的城市,分类列表
	public ArrayList<DestinationCity_DestCityDetailView> GroupCityList;
}
