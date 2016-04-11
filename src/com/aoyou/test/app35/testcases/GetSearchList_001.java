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
				this.checkPoint.equals(getSearchListResult.Message,"����������Ϣ�ɹ�","ִ����Ϣֵ����ȷ,����ֵΪ:["+getSearchListResult.Message+"],����ֵΪ:[����������Ϣ�ɹ�]");
				int length=getSearchListResult.Data.list.size();
				for(int i=0;i<length;i++){
					this.checkPoint.equals(String.valueOf(getSearchListResult.Data.list.get(i).board_id), getSearchListParamModel.SrchFid, "�ش��İ��ID����ȷ,����Ϊ["+getSearchListResult.Data.list.get(i).board_id+"],�������Ϊ:["+getSearchListParamModel.SrchFid+"]");
					this.checkPoint.contains(getSearchListResult.Data.list.get(i).title, getSearchListParamModel.Keyword, "У��ؼ���ʧ��,�ش���topic_idΪ:["+getSearchListResult.Data.list.get(i).topic_id+"]�������title�в������ؼ���["+getSearchListParamModel.Keyword+"]");
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬�룺"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]���ID:["+getSearchListParamModel.SrchFid+"],��ѯ�ؼ���:["+getSearchListParamModel.Keyword+"]��Ϣ��ȡ�ɹ�");
	}
}
