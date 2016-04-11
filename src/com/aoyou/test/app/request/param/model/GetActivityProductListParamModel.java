package com.aoyou.test.app.request.param.model;

public class GetActivityProductListParamModel {

	//分页页号，默认为1
	public int PageIndex;
	
	//分页每页显示条数，默认为10
	public int PageCount;
	
	//销售渠道，默认为0，即全部，手机专享属于该筛选条件，传3
	public int SalesChannel;
	
	//产品类型，默认为0，即全部，4：自由行，1：参团，6：单项产品
	public int ProductType;
	
	//出发城市ID,默认为0，即全部
	public int cityid;
	
	//目的地城市ID，默认为0，即全部
	public int destcityid;
	
	//产品排序，默认0，1最新上线排列2价格升序排列，3价格降序排列，4折扣升序排列,5折扣降序排列
	public int SortBy;
	
	//是否过滤售罄产品  （true 过滤 false 不过滤）
	public boolean IsSoldOut;

}
