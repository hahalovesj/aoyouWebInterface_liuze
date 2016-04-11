package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetPostListResult;
import com.aoyou.test.app.request.GetPostListRequest;
import com.aoyou.test.app.request.param.model.GetPostListParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.google.gson.Gson;

public class GetPostList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getPostList_001(){
		
		this.test=new GetPostListRequest();
		this.test.sendPost();
		GetPostListParamModel getPostListParamModel=((RestServiceTemplate)this.test).getRequestParamMode();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			Gson gson=new Gson();
			String responseString=this.test.getResponseString();
			GetPostListResult getPostListResult=gson.fromJson(responseString, GetPostListResult.class);
			if(getPostListResult.ReturnCode==0){
				this.checkPoint.equals(getPostListResult.Message, "查询主题信息成功", "执行消息值不正确,返回值为:["+getPostListResult.Message+"],期望值为:[查询主题信息成功]");
				this.checkPoint.equals(getPostListResult.Data.topic.topic_id,getPostListParamModel.TopicId,"主题ID不正确,返回值为:["+getPostListResult.Data.topic.topic_id+"],期望值为:["+getPostListParamModel.TopicId+"]");
				this.checkPoint.equals(getPostListResult.Data.page,getPostListParamModel.PageNo,"页码不正确,返回值为:["+getPostListResult.Data.page+"],期望值为:["+getPostListParamModel.PageNo+"]");
				this.checkPoint.equals(getPostListResult.Data.boardId,String.valueOf(getPostListParamModel.Fid),"板块ID不正确,返回值为["+getPostListResult.Data.boardId+"],期望值为:["+getPostListParamModel.Fid+"]");
			}
		}else{
			this.checkPoint.isFaild("接口请求失败，状态码："+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]板块ID：["+getPostListParamModel.Fid+"],主题ID：["+getPostListParamModel.TopicId+"]信息获取成功");
	}
}
