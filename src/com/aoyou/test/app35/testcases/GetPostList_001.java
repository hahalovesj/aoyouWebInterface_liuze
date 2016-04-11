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
				this.checkPoint.equals(getPostListResult.Message, "��ѯ������Ϣ�ɹ�", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getPostListResult.Message+"],����ֵΪ:[��ѯ������Ϣ�ɹ�]");
				this.checkPoint.equals(getPostListResult.Data.topic.topic_id,getPostListParamModel.TopicId,"����ID����ȷ,����ֵΪ:["+getPostListResult.Data.topic.topic_id+"],����ֵΪ:["+getPostListParamModel.TopicId+"]");
				this.checkPoint.equals(getPostListResult.Data.page,getPostListParamModel.PageNo,"ҳ�벻��ȷ,����ֵΪ:["+getPostListResult.Data.page+"],����ֵΪ:["+getPostListParamModel.PageNo+"]");
				this.checkPoint.equals(getPostListResult.Data.boardId,String.valueOf(getPostListParamModel.Fid),"���ID����ȷ,����ֵΪ["+getPostListResult.Data.boardId+"],����ֵΪ:["+getPostListParamModel.Fid+"]");
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬�룺"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]���ID��["+getPostListParamModel.Fid+"],����ID��["+getPostListParamModel.TopicId+"]��Ϣ��ȡ�ɹ�");
	}
}
