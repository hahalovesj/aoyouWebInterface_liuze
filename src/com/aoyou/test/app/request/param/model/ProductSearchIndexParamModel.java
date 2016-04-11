package com.aoyou.test.app.request.param.model;

import java.util.ArrayList;
import java.util.List;

public class ProductSearchIndexParamModel {

	//��������
	public int DepartCityID;
	
	//��ǩID����
	public List<Integer> LabelIDList=new ArrayList<Integer>();
	
	//�ų��Ĳ�Ʒ���ͼ���(5���� 7��Ʊ 97��98��ͨ�� 1001 Aoyouerp�����в�Ʒ)
	public List<Integer> ExcludeProductTypeList=new ArrayList<Integer>();
	
	//��Ʒ��ʶ�ж�
	public List<ProductSearchIndex_ProductMarkModel> ProductMarkDic=new ArrayList<ProductSearchIndex_ProductMarkModel>();
	
	//��Ʒ���ͼ���(1���� 4 ������ 26��Ʊ 96 ǩ֤ 99���� )
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
