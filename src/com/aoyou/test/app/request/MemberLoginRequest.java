package com.aoyou.test.app.request;

import java.io.File;
import java.io.FileNotFoundException;

import com.aoyou.test.app.request.param.model.MemberLoginParamModel;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.ParseXmlString;

public class MemberLoginRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		ParseXmlString pxs=new ParseXmlString();
		try {
			pxs.Load(new File("config/app.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String loginName=pxs.getElementObject("//url[@version='"+this.version+"']").attributeValue("loginname");
		String password=pxs.getElementObject("//url[@version='"+this.version+"']").attributeValue("password");
		MemberLoginParamModel memberLoginParamModel=new MemberLoginParamModel();
		memberLoginParamModel.LoginName=loginName;
		memberLoginParamModel.Password=password;
		this.paramModel=(Object)memberLoginParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

	
}
