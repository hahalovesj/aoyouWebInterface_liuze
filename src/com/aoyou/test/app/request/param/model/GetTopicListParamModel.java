package com.aoyou.test.app.request.param.model;

public class GetTopicListParamModel {

	//���ΰ�(���ID37)/ս��Ʒ(���ID 167)
	public int Fid;
	
	//����������ѯʱ������Ϊ��typeid,FilterId ���ö�Ӧ�ķ���ID����������Ϊ�������������ʴ���ʱ����Ҫ��ѯ����������Ϊ��digest
	public String FilterType;
		
	//ս��Ʒ�������ID��367 (ɹս��Ʒ����ID)����;ֱ����223
	public String FilterId;
	
	//�Ƿ���ʾͼƬ�б�
	public int IsImageList;
	
	//����ʽ(all:lastpost | new:���� | top:�ö� | marrow:����)��Ĭ������Ϊ��all
	public String Sortby;
	
	//��ǰҳ
	public int PageNo;
	
	//��ҳ��С
	public int PageSize;
	
	//Ĭ��ֵ��1
	public int IsRatio=1;
	
	//Ĭ��ֵ��0
	public int TopOrder=0;
}
