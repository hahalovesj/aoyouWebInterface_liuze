package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.SearchMemberPointDetailResult;
import com.aoyou.test.app.request.SearchMemberPointDetailRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class SearchMemberPointDetail_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void searchMemberPointDetail_001(){
		
		this.test=new SearchMemberPointDetailRequest();
		this.test.sendPost();
		
		int status=this.test.getStatus();
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		
		if(status==HttpStatus.OK.value()){
			SearchMemberPointDetailResult searchNewResult=(SearchMemberPointDetailResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(searchNewResult.ReturnCode==0){
				//this.checkPoint.equals(searchNewResult.Message,"��Ʒ�б��ѯ�ɹ�!","ִ����Ϣֵ����ȷ,����ֵΪ:["+searchNewResult.Message+"],����ֵΪ:[��Ʒ�б��ѯ�ɹ�!]");
			
				int size =searchNewResult.Data.size();
				if(size>0){
					//�˴������ӽڵ���֤
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿڵ���ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡ��������ɹ�");
	}
}
