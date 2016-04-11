package com.aoyou.test.app.Result.contentModel;

import java.util.List;

public class GetSearchList_SearchListModel {

	//页码
	public int page;
	
	//1:存在下一页；0：不存在
	public int has_next;
	
	//记录总数
	public int total_num;
	
	//板块列表
	public List<GetSearchList_BoardInfoModel> list;
	
	public String newTopicPanel;
	
	public String classificationTop_list;
	
	public String classificationType_list;
	
	public int isOnlyTopicType;
	
	public String anno_list;
	
	public String forumInfo;
	
	public String topTopicList;
}
