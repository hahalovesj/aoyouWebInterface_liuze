package com.aoyou.test.app.Result.contentModel;

import java.util.List;

public class GetADInfoBySpaceGUID_AdvertisementModel {
	
	//广告列表，详细见下表
	public List<GetADInfoBySpaceGUID_AdsInfoModel> Advertisements;
	
	//图片地址
	public String PicUrl;
	
	//位置名称
	public String SpaceName;
	
	//位置链接
	public String SpaceURL;
	
	//标题
	public String Title;
	
	//说明
	public String Description;
}
