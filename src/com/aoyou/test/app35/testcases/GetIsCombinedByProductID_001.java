package com.aoyou.test.app35.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetIsCombinedByProductIDResult;
import com.aoyou.test.app.request.GetIsCombinedByProductIDRequest;
import com.aoyou.test.app.request.param.model.GetCombinedProductPriceCalendarParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.HttpStatus;

public class GetIsCombinedByProductID_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@Test
	public void getIsCombinedByProductID_001(){
		
		this.test=new GetIsCombinedByProductIDRequest();
		this.test.sendPost();
		
		//System.out.println(this.test.getResponseString());
		GetCombinedProductPriceCalendarParamModel getCombinedProductPriceCalendarParamModel=((RestServiceTemplate) this.test).getRequestParamMode();
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		
		if(status==HttpStatus.OK.value()){
			GetIsCombinedByProductIDResult getIsCombinedByProductIDResult=(GetIsCombinedByProductIDResult) ((RestServiceTemplate) this.test).getResponseMode();			
			this.checkPoint.equals(getIsCombinedByProductIDResult.Data.IsCombined, getCombinedProductPriceCalendarParamModel.isCombined, "��Ʒ�Ƿ�Combined����������ֵΪ["+getIsCombinedByProductIDResult.Data.IsCombined+"],�������Ϊ["+getCombinedProductPriceCalendarParamModel.isCombined+"]");
			if(getIsCombinedByProductIDResult.ReturnCode==0){
				this.checkPoint.equals(getIsCombinedByProductIDResult.Message, "�Ƿ�Ϊ�����Ʋ�Ʒ���óɹ�!", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getIsCombinedByProductIDResult.Message+"],����ֵΪ:[�Ƿ�Ϊ�����Ʋ�Ʒ���óɹ�!]");
			}else{
				this.checkPoint.equals(getIsCombinedByProductIDResult.Message, "�Ƿ�Ϊ�����Ʋ�Ʒ����ʧ��!", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getIsCombinedByProductIDResult.Message+"],����ֵΪ:[�Ƿ�Ϊ�����Ʋ�Ʒ����ʧ��!]");
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ƷID["+getCombinedProductPriceCalendarParamModel.productID+"]Combined��Ʒ״̬Ϊ["+getCombinedProductPriceCalendarParamModel.isCombined+"]");
	}
}
