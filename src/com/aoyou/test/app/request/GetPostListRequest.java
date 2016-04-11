package com.aoyou.test.app.request;

import com.aoyou.test.app.Result.model.GetTopicListResult;
import com.aoyou.test.app.request.param.model.GetPostListParamModel;
import com.aoyou.test.base.Action;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetPostListRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetTopicListResult  getTopicListResult=Action.getTopicIdList();
		GetPostListParamModel getPostListParamModel=new GetPostListParamModel();
		getPostListParamModel.Fid=getTopicListResult.Data.list.get(0).board_id;
		getPostListParamModel.TopicId=getTopicListResult.Data.list.get(0).topic_id;
		getPostListParamModel.Order=0;
		getPostListParamModel.PageNo=1;
		getPostListParamModel.PageSize=10;
		this.paramModel=(Object)getPostListParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
