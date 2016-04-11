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
				
				this.checkPoint.equals(getTopicListResult.Message,"��ѯ��������б����","ִ����Ϣֵ����ȷ,����ֵΪ:["+getTopicListResult.Message+"],����ֵΪ:[��ѯ��������б����]");				
				
				this.checkPoint.equals(getTopicListResult.Data.forumInfo.id, getTopicListParamModel.Fid, "�ش�forumInfo�����еİ��ID�������һ�£���ΰ��IDΪ:["+getTopicListParamModel.Fid+"],�ش����İ��IDΪ��["+getTopicListResult.Data.forumInfo.id+"]");
				//check Topic�еİ��ID
				int length=getTopicListResult.Data.list.size();
				for(int i=0;i<length;i++){
					int board_id=getTopicListResult.Data.list.get(i).board_id;					
					this.checkPoint.equals(board_id, getTopicListParamModel.Fid, "�ش�list�е�topicinfo�İ��ID����β�һ�£���ΰ��IDΪ��["+getTopicListParamModel.Fid+"],�ش����İ��IDΪ:["+board_id+"],����ֵΪ["+i+"]");
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ��!״̬��"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]���ID["+getTopicListParamModel.Fid+"]�����б��ȡ�ɹ�");
	}
}
