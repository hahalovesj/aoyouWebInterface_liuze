package com.aoyou.test.app.Result.contentModel;

import java.util.List;

public class GetSearchList_SearchListModel {

	//ҳ��
	public int page;
	
	//1:������һҳ��0��������
	public int has_next;
	
	//��¼����
	public int total_num;
	
	//����б�
	public List<GetSearchList_BoardInfoModel> list;
	
	public String newTopicPanel;
	
	public String classificationTop_list;
	
	public String classificationType_list;
	
	public int isOnlyTopicType;
	
	public String anno_list;
	
	public String forumInfo;
	
	public String topTopicList;
}
