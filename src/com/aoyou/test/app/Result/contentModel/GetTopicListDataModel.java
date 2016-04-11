package com.aoyou.test.app.Result.contentModel;

import java.util.List;

public class GetTopicListDataModel {

	public int page;
	
	public int has_next;
	
	public int total_num;
	
	public GetTopicList_forumInfoModel forumInfo;
	
	public List<GetTopicList_topicInfoModel> list;
	
	public List<GetTopicList_classificationTypeModel> classificationType_list;
}
