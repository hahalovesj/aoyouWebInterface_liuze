package com.aoyou.test.app.request.param.model;

import java.util.ArrayList;
import java.util.List;

public class SearchNew_searchConditionParamModel {

	public List<Integer> ExcludeProductTypeList=new ArrayList<Integer>();
	
	public List<Integer> LabelIDList=new ArrayList<Integer>();
	
	public int DepartCityID=1;
	
	public List<SearchNew_MarkDicParamModel> ProductMarkDic=new ArrayList<SearchNew_MarkDicParamModel>();
	
	public SearchNew_searchConditionParamModel(){
		this.ExcludeProductTypeList.add(5);
		this.ExcludeProductTypeList.add(7);
		this.ExcludeProductTypeList.add(98);
		this.ExcludeProductTypeList.add(97);
		this.ExcludeProductTypeList.add(1001);
		this.LabelIDList.add(90);
		this.LabelIDList.add(104);
		for(int i=0;i<4;i++){
			if(i!=2){
				SearchNew_MarkDicParamModel searchNew_MarkDicParamModel=new SearchNew_MarkDicParamModel();
				searchNew_MarkDicParamModel.MarkType=String.valueOf(i);
				searchNew_MarkDicParamModel.MarkValue=false;
				this.ProductMarkDic.add(searchNew_MarkDicParamModel);
			}
		}
	}
}
