package com.aoyou.test.app.Result.contentModel;

import java.util.List;

public class GetActivityPanicBuyingProducts_ProductInfoModel {

	//��ʱ������������
	public String ActivityPanicName;
	
	//Ŀ�ĵس���ID
	public int DestCityID;
	
	//��������(1�������� 2��������)
	public int PanicType;
	
	//��Ʒʣ������
	public int ProductNum;
	
	//����
	public List<GetActivityPanicBuyingProducts_ProductViewInfoModel> ActivityProductView;
}
