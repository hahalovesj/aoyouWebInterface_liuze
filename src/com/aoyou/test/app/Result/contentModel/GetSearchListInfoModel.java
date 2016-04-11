package com.aoyou.test.app.Result.contentModel;

import java.util.List;

public class GetSearchListInfoModel {

	public int page;
	
	public int has_next;
	
	public int total_num;
	
	public List<GetSearchList_TopicModel> list;
	
	public GetPostList_headModel head;
	
	public GetPostList_bodyModel body;
}
