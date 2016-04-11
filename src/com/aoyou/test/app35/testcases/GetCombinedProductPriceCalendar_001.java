package com.aoyou.test.app35.testcases;

import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.app.Result.model.GetCombinedProductPriceCalendarResult;
import com.aoyou.test.app.request.GetCombinedProductPriceCalendarRequest;
import com.aoyou.test.app.request.param.model.GetCombinedProductPriceCalendarParamModel;
import com.aoyou.test.base.Data;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.Common;
import com.aoyou.test.util.HttpStatus;

public class GetCombinedProductPriceCalendar_001 extends TestBase{

	@BeforeClass
	public void setUp(){
		Data.currentClassName=this.getClass().getSimpleName();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getCombinedProductPriceCalendarRequest(){
		
		this.test=new GetCombinedProductPriceCalendarRequest();
		this.test.sendPost();
		//System.out.println(this.test.getResponseString());
		GetCombinedProductPriceCalendarParamModel getCombinedProductPriceCalendar=((RestServiceTemplate) this.test).getRequestParamMode();
		
		int runTime=((RestServiceTemplate) this.test).getRunTime();
		int status=this.test.getStatus();
		
		if(status==HttpStatus.OK.value()){
			GetCombinedProductPriceCalendarResult getCombinedProductPriceCalendarResult=(GetCombinedProductPriceCalendarResult) ((RestServiceTemplate) this.test).getResponseMode();
			if(getCombinedProductPriceCalendarResult.ReturnCode==0){
				this.checkPoint.equals(getCombinedProductPriceCalendarResult.Message,"�ɹ�", "ִ����Ϣֵ����ȷ,����ֵΪ:["+getCombinedProductPriceCalendarResult.Message+"],����ֵΪ:[�ɹ�]");
				int itemSize=getCombinedProductPriceCalendarResult.Data.ItemList.size();
				if(itemSize>0){
					for(int i=0;i<itemSize;i++){
						int year=getCombinedProductPriceCalendarResult.Data.ItemList.get(i).year;
						int month=getCombinedProductPriceCalendarResult.Data.ItemList.get(i).month;
						int salesItemSize=getCombinedProductPriceCalendarResult.Data.ItemList.get(i).SalesItemViewList.size();
						if(salesItemSize>0){
							for(int j=0;j<salesItemSize;j++){
								Date date=Common.getDate(getCombinedProductPriceCalendarResult.Data.ItemList.get(i).SalesItemViewList.get(j).DepartDate);
								//System.out.println(date);
								this.checkPoint.equals(date.getYear()+1900, year, "���ؼ۸������ĳ���������ݲ�ƥ��,��Ʒ�г����������Ϊ["+(date.getYear()+1900)+"],���Ϊ["+year+"]");
								this.checkPoint.equals(date.getMonth()+1, month, "���ؼ۸������ĳ��������·ݲ�ƥ��,��Ʒ�г��������·�Ϊ["+(date.getMonth()+1)+"],���Ϊ["+month+"]");
							}
						}
					}
				}
			}
		}else{
			this.checkPoint.isFaild("�ӿ�����ʧ�ܣ�״̬��:"+status);
		}
		
		this.checkPoint.result("[ִ��ʱ��:"+runTime+"ms]��ƷID["+getCombinedProductPriceCalendar.productID+"]�۸�������ȡ�ɹ���");
	}
}
