package com.aoyou.test.app.request.param.model;

public class GetTicketCityListParamModel {

	//��������0��Ĭ������1������2���۸�
	public int SortType;
	
	//ÿҳ����,mĬ��Ϊ10
	public int RowNum=10;
	
	//ҳ��
	public int PageNum=1;
	
	//����ʽ	0������1������
	public int SortMode;
	
	//�Ƿ�Ϊ���� (Ԥ�Ƶ��տ���԰)
	public boolean IsNowDay;
	
	//�ؼ���
	public String Key_Word;
}
