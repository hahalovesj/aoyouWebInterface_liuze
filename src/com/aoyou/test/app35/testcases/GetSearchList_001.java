package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetSearchListResult;
import com.aoyou.test.app.request.GetSearchListRequest;
import com.aoyou.test.app.request.param.model.GetSearchListParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetSearchList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getSearchList_001(){
		
		this.test=new GetSearchListRequest();
		this.test.sendPost();		
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		GetSearchListParamModel getSearchListParamModel=((RestServiceTemplate)this.test).getRequestParamMode();
		int status =this.test.getStatus();
		if(status==200){
			GetSearchListResult getSearchListResult=(GetSearchListResult)((RestServiceTemplate)this.test).getResponseMode();
			//System.out.println(getSearchListResult.Message);
			if(getSearchListResult.ReturnCode==0){
				this.checkPoint.equals(getSearchListResult.Message,"搜索主题信息成功","执行消息值不正确,返回值为:["+getSearchListResult.Message+"],期望值为:[搜索主题信息成功]");
				int length=getSearchListResult.Data.list.size();
				for(int i=0;i<length;i++){
					this.checkPoint.equals(String.valueOf(getSearchListResult.Data.list.get(i).board_id), getSearchListParamModel.SrchFid, "回传的板块ID不正确,返回为["+getSearchListResult.Data.list.get(i).board_id+"],期望结果为:["+getSearchListParamModel.SrchFid+"]");
					this.checkPoint.contains(getSearchListResult.Data.list.get(i).title, getSearchListParamModel.Keyword, "校验关键字失败,回传的topic_id为:["+getSearchListResult.Data.list.get(i).topic_id+"]的主题的title中不包含关键字["+getSearchListParamModel.Keyword+"]");
				}
			}
		}else{
			this.checkPoint.isFaild("接口请求失败，状态码："+status);
		}
		
		this.checkPoint.result("[执行时间:"+runTime+"ms]板块ID:["+getSearchListParamModel.SrchFid+"],查询关键字:["+getSearchListParamModel.Keyword+"]信息获取成功");
	}
}
