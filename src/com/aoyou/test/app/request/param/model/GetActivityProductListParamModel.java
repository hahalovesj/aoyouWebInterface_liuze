package com.aoyou.test.app.request.param.model;

public class GetActivityProductListParamModel {

	//��ҳҳ�ţ�Ĭ��Ϊ1
	public int PageIndex;
	
	//��ҳÿҳ��ʾ������Ĭ��Ϊ10
	public int PageCount;
	
	//����������Ĭ��Ϊ0����ȫ�����ֻ�ר�����ڸ�ɸѡ��������3
	public int SalesChannel;
	
	//��Ʒ���ͣ�Ĭ��Ϊ0����ȫ����4�������У�1�����ţ�6�������Ʒ
	public int ProductType;
	
	//��������ID,Ĭ��Ϊ0����ȫ��
	public int cityid;
	
	//Ŀ�ĵس���ID��Ĭ��Ϊ0����ȫ��
	public int destcityid;
	
	//��Ʒ����Ĭ��0��1������������2�۸��������У�3�۸������У�4�ۿ���������,5�ۿ۽�������
	public int SortBy;
	
	//�Ƿ����������Ʒ  ��true ���� false �����ˣ�
	public boolean IsSoldOut;

}
