package com.aoyou.test.app.request.param.model;

import java.util.ArrayList;
import java.util.List;

public class ProductSearchIndexParamModel {

	//出发城市
	public int DepartCityID;
	
	//标签ID集合
	public List<Integer> LabelIDList=new ArrayList<Integer>();
	
	//排除的产品类型集合(5游轮 7机票 97、98互通卡 1001 Aoyouerp自由行产品)
	public List<Integer> ExcludeProductTypeList=new ArrayList<Integer>();
	
	//产品标识判断
	public List<ProductSearchIndex_ProductMarkModel> ProductMarkDic=new ArrayList<ProductSearchIndex_ProductMarkModel>();
	
	//产品类型集合(1参团 4 自由行 26门票 96 签证 99单项 )
	public List<Integer> ProductTypeList=new ArrayList<Integer>();
	
	
	public ProductSearchIndexParamModel(){
		this.LabelIDList.add(8);
		this.LabelIDList.add(133);
		this.LabelIDList.add(37);
		this.ExcludeProductTypeList.add(5);
		this.ExcludeProductTypeList.add(7);
		this.ExcludeProductTypeList.add(97);
		this.ExcludeProductTypeList.add(98);
		this.ExcludeProductTypeList.add(1001);
		for(int i=0;i<4;i++){
			ProductSearchIndex_ProductMarkModel aroductSearchIndex_ProductMarkModel=new ProductSearchIndex_ProductMarkModel();
			aroductSearchIndex_ProductMarkModel.MarkType=i;
			aroductSearchIndex_ProductMarkModel.MarkValue=false;
			this.ProductMarkDic.add(aroductSearchIndex_ProductMarkModel);
		}
		this.ProductTypeList.add(1);
		this.ProductTypeList.add(4);
		this.ProductTypeList.add(26);
		this.ProductTypeList.add(96);
		this.ProductTypeList.add(99);
	}
}
