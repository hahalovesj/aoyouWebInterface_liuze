package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.SearchNewResult;
import com.aoyou.test.app.request.SearchNewRequest;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class SearchNew_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void searchNew_001(){
		
		this.test=new SearchNewRequest();
		this.test.sendPost();
		
		int status=this.test.getStatus();
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		
		if(status==HttpStatus.OK.value()){
			SearchNewResult searchNewResult=(SearchNewResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(searchNewResult.ReturnCode==0){
				this.checkPoint.equals(searchNewResult.Message,"��Ʒ�б��ѯ�ɹ�!","ִ����Ϣֵ����ȷ,����ֵΪ:["+searchNewResult.Message+"],����ֵΪ:[��Ʒ�б��ѯ�ɹ�!]");
			
				int size =searchNewResult.Data.FilterItemList.size();
				if(size>0){
					//�˴������ӽڵ���֤
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿڵ���ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��Ʒ�б��ѯ�ɹ�!");
	}
}
