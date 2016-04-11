package com.aoyou.test.app.request.param.model;

public class GetTermsParamModel {

	//默认为1，要获取的期个数，例如：3代表获取最新的3期数据
	public int takeTermCount=1;
	
	//默认是0，获取下一页时取上次获取的最后一条数据的期数TermNumber
	public int lastTakedTermNumber=0;
}
