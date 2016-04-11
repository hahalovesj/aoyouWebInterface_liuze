package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.DestinationCityForAppIndexResult;
import com.aoyou.test.app.request.DestinationCityForAppIndexRequest;
import com.aoyou.test.app.request.param.model.DestinationCityForAppIndexParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class DestinationCityForAppIndex_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void destinationCityForAppIndex_001(){
		
		this.test=new DestinationCityForAppIndexRequest();
		DestinationCityForAppIndexParamModel destinationCityForAppIndexParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		destinationCityForAppIndexParamModel.ForeignFlag=false;
		this.test.sendPost();
		
		int status=this.test.getStatus();
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		
		if(status==HttpStatus.OK.value()){
			DestinationCityForAppIndexResult estinationCityForAppIndexResult=(DestinationCityForAppIndexResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(estinationCityForAppIndexResult.ReturnCode==0){
				this.checkPoint.equals(estinationCityForAppIndexResult.Message, "��ȡ�����Ρ�������Ŀ�ĵس��гɹ�!", "ִ����Ϣֵ����ȷ,����ֵΪ:["+estinationCityForAppIndexResult.Message+"],����ֵΪ:[��ȡ�����Ρ�������Ŀ�ĵس��гɹ�!]");
				
				int size =estinationCityForAppIndexResult.Data.Cities.size();
				if(size>0){
					//�˴������ӽڵ���֤
					for(int i=0;i<size;i++){
						this.checkPoint.equals(estinationCityForAppIndexResult.Data.Cities.get(i).GroupName, "����", "�ش����з�����������ڲ���������ֵΪ:["+estinationCityForAppIndexResult.Data.Cities.get(i).GroupName+"],����ֵΪ:[����]");
					}
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿڵ���ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]���ڳ��л�ȡ�ɹ���");
	}
	
	@Test
	public void destinationCityForAppIndex_002(){
		
		this.test=new DestinationCityForAppIndexRequest();
		this.test.sendPost();
		
		int status=this.test.getStatus();
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		
		if(status==HttpStatus.OK.value()){
			DestinationCityForAppIndexResult estinationCityForAppIndexResult=(DestinationCityForAppIndexResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(estinationCityForAppIndexResult.ReturnCode==0){
				this.checkPoint.equals(estinationCityForAppIndexResult.Message, "��ȡ�����Ρ�������Ŀ�ĵس��гɹ�!", "ִ����Ϣֵ����ȷ,����ֵΪ:["+estinationCityForAppIndexResult.Message+"],����ֵΪ:[��ȡ�����Ρ�������Ŀ�ĵس��гɹ�!]");
				
				int size =estinationCityForAppIndexResult.Data.Cities.size();
				if(size>0){
					//�˴������ӽڵ���֤
					for(int i=0;i<size;i++){
						this.checkPoint.equals(estinationCityForAppIndexResult.Data.Cities.get(i).GroupName, "����", "�ش����з�����������ڲ���������ֵΪ:["+estinationCityForAppIndexResult.Data.Cities.get(i).GroupName+"],����ֵΪ:[����]");
					}
				}else{
					
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿڵ���ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]���ڳ��л�ȡ�ɹ���");
	}
}
