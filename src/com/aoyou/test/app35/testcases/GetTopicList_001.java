package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetTopicListResult;
import com.aoyou.test.app.request.GetTopicListRequest;
import com.aoyou.test.app.request.param.model.GetTopicListParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.google.gson.Gson;


public class GetTopicList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getTopicList_001(){
		
		this.test=new GetTopicListRequest();
		this.test.sendPost();
		GetTopicListParamModel getTopicListParamModel=((RestServiceTemplate)this.test).getRequestParamMode();
		int status=this.test.getStatus();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		if(status==200){
			Gson gson=new Gson();
			String responseString=this.test.getResponseString();
			GetTopicListResult getTopicListResult=gson.fromJson(responseString, GetTopicListResult.class);
			if(getTopicListResult.ReturnCode==0){
				
				this.checkPoint.equals(getTopicListResult.Message,"查询板块主题列表完成","执行消息值不正确,返回值为:["+getTopicListResult.Message+"],期望值为:[查询板块主题列表完成]");				
				
				this.checkPoint.equals(getTopicListResult.Data.forumInfo.id, getTopicListParamModel.Fid, "回传forumInfo数据中的板块ID与参数不一致，入参板块ID为:["+getTopicListParamModel.Fid+"],回传报文板块ID为：["+getTopicListResult.Data.forumInfo.id+"]");
				//check Topic中的板块ID
				int length=getTopicListResult.Data.list.size();
				for(int i=0;i<length;i++){
					int board_id=getTopicListResult.Data.list.get(i).board_id;					
					this.checkPoint.equals(board_id, getTopicListParamModel.Fid, "回传list中的topicinfo的板块ID与入参不一致，入参板块ID为：["+getTopicListParamModel.Fid+"],回传报文板块ID为:["+board_id+"],索引值为["+i+"]");
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败!状态码"+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]板块ID["+getTopicListParamModel.Fid+"]主题列表获取成功");
	}
}
