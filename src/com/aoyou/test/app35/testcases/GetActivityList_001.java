package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aoyou.test.app.Result.model.GetActivityListResult;
import com.aoyou.test.app.request.GetActivityListRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;

public class GetActivityList_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getActivityList_001(){
		
		this.test=new GetActivityListRequest();
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			GetActivityListResult getActivityListResult=(GetActivityListResult)((RestServiceTemplate)this.test).getResponseMode();
			
			if(getActivityListResult.ReturnCode==0){
				this.checkPoint.equals(getActivityListResult.Message, "��ȡApp��ҳBanner��б�ɹ�!", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getActivityListResult.Message+"],����ֵΪ:[��ȡApp��ҳBanner��б�ɹ�!]");
			}
			
			int size =getActivityListResult.Data.size();
			if(size>0){
				//�˴������ӽڵ���֤
			}else{
				
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ��!״̬��"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡApp��ҳBanner��б�ɹ�!");
	}
}
