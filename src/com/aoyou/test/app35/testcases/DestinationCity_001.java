package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aoyou.test.app.Result.model.DestinationCityResult;
import com.aoyou.test.app.request.DestinationCityRequest;
import com.aoyou.test.app.request.param.model.DestinationCityParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.google.gson.Gson;

public class DestinationCity_001 extends TestBase{


	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	//����
	@Test
	public void destinationCity_001(){
		
		this.test=new DestinationCityRequest();
		DestinationCityParamModel destinationCityParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		//����Ŀ�ĵ�
		destinationCityParamModel.ForeignFlag=false;
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			DestinationCityResult destinationCityResult=(DestinationCityResult)((RestServiceTemplate)this.test).getResponseMode();
			if(destinationCityResult.ReturnCode==0){
				this.checkPoint.equals(destinationCityResult.Message,"��ȡĿ�ĵس��гɹ�!","ִ����Ϣֵ����ȷ,����ֵΪ:["+destinationCityResult.Message+"],����ֵΪ:[��ȡĿ�ĵس��гɹ�!]");
				int size =destinationCityResult.Data.size();
				if(size>0){
					//�˴������ӽڵ���֤
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ��!״̬��"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡ[����]Ŀ�ĵس����б�ɹ���");
	}
	
	//����
	@Test
	public void destinationCity_002(){
		
		this.test=new DestinationCityRequest();
		DestinationCityParamModel destinationCityParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		//����Ŀ�ĵ�
		destinationCityParamModel.ForeignFlag=true;
		this.test.sendPost();
		int runTime=((RestServiceTemplate)this.test).getRunTime();
		int status=this.test.getStatus();
		if(status==200){
			Gson gson=new Gson();
			String responseString=this.test.getResponseString();
			DestinationCityResult destinationCityResult=gson.fromJson(responseString, DestinationCityResult.class);
			if(destinationCityResult.ReturnCode==0){
				this.checkPoint.equals(destinationCityResult.Message,"��ȡĿ�ĵس��гɹ�!","ִ����Ϣֵ����ȷ,����ֵΪ:["+destinationCityResult.Message+"],����ֵΪ:[��ȡĿ�ĵس��гɹ�!]");
				int size =destinationCityResult.Data.size();
				//У�������ǹ�Ϊ�գ�message��code�������ʱ
				if(size<=0){
					this.checkPoint.equals(size>0,true,"����Ŀ�ĵس���Ϊ�գ�");
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ��!״̬��"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ȡ[����]Ŀ�ĵس����б�ɹ���");
	}
}
