package com.aoyou.test.app.request.param.model;

public class ReplyThreadParamModel {

	//板块ID
	public int Fid;
	
	//默认：1，是否引用
	public int isQuote=1;
	
	//默认：1，是否显示楼层
	public int isShowPosition=1;
	
	//主题ID
	public String TID;
	
	//内容
	public String Message;
	
	//标题
	public String Subject;
	
	//会员ID
	public int MemberId=-1;
}
