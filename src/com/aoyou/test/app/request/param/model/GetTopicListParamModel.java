package com.aoyou.test.app.request.param.model;

public class GetTopicListParamModel {

	//遨游帮(板块ID37)/战利品(板块ID 167)
	public int Fid;
	
	//按主题分类查询时，设置为：typeid,FilterId 设置对应的分类ID。否则设置为：“”，调用问答板块时，需要查询精华帖设置为：digest
	public String FilterType;
		
	//战利品主题分类ID：367 (晒战利品分类ID)，旅途直播：223
	public String FilterId;
	
	//是否显示图片列表
	public int IsImageList;
	
	//排序方式(all:lastpost | new:最新 | top:置顶 | marrow:精华)，默认设置为：all
	public String Sortby;
	
	//当前页
	public int PageNo;
	
	//分页大小
	public int PageSize;
	
	//默认值：1
	public int IsRatio=1;
	
	//默认值：0
	public int TopOrder=0;
}
