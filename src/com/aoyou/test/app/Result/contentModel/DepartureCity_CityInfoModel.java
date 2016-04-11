package com.aoyou.test.app.Result.contentModel;

import java.util.ArrayList;

public class DepartureCity_CityInfoModel {

	//版本号
	public String Ver;
	
	//区域ID
	public int RegionID;
	
	//区域名称
	public String RegionName;
	
	//区域包含城市
	public ArrayList<DepartureCity_DepartureCityDetailViewModel> CityView;
}
