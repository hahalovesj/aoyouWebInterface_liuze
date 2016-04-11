package com.aoyou.test.app.Result.contentModel;

import java.util.List;

public class SearchNew_SearchResultViewModel {

	//查询结果编码
	public String SearchResultCode;
	
	//未筛选前的总产品数
	public int ProductTotalCount;
	
	//
	public List<SearchNew_FilterItemModel> FilterItemList;
	
	public List<SearchNew_ProductInfoModel> ProductList;
	
	public int SearchType;
}
