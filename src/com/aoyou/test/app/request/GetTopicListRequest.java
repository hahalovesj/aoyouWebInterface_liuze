package com.aoyou.test.app.request;

import com.aoyou.test.app.request.param.model.GetTopicListParamModel;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetTopicListRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		GetTopicListParamModel getTopicListParamModel=new GetTopicListParamModel();
		getTopicListParamModel.Fid=167;
		getTopicListParamModel.IsImageList=1;
		getTopicListParamModel.Sortby="marrow";
		getTopicListParamModel.PageNo=1;
		getTopicListParamModel.PageSize=10;
		getTopicListParamModel.IsRatio=1;
		getTopicListParamModel.TopOrder=0;
		this.paramModel=(Object)getTopicListParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
