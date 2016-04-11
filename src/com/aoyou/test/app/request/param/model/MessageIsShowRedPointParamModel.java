package com.aoyou.test.app.request.param.model;

public class MessageIsShowRedPointParamModel {

	//获取是否显示红点的方式：0获取是否有最新消息,有则显示，无则不显示,1 重新获取是否有最新消息，包含之前已获取过的，有则显示，无则不显示
	public int readType;
}
