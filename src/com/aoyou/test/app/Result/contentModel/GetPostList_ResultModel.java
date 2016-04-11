package com.aoyou.test.app.Result.contentModel;

import java.util.List;

public class GetPostList_ResultModel {

	public GetPostList_topicInfo topic;
	
	public List<GetPostList_TopicListInfoModel> list;
	
	public int page;
	
	public int has_next;
	
	public int total_num;
	
	public String forumName;
	
	public String boardId;
	
	public String forumTopicUrl;
	
	public String img_url;
	
	public String icon_url;
	
	public int rs;
	
	public String errcode;
	
	public GetPostList_headModel head;
	
	public GetPostList_bodyModel body;
}
