package com.aoyou.test.app.request.param.model;

public class GetTicketCityListParamModel {

	//排序类型0：默认排序1：销量2：价格
	public int SortType;
	
	//每页条数,m默认为10
	public int RowNum=10;
	
	//页码
	public int PageNum=1;
	
	//排序方式	0：升序1：降序
	public int SortMode;
	
	//是否为当日 (预计当日可入园)
	public boolean IsNowDay;
	
	//关键字
	public String Key_Word;
}
