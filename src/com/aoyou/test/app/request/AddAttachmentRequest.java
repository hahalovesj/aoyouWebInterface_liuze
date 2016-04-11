package com.aoyou.test.app.request;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aoyou.test.app.request.param.model.AddAttachmentParamModel;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.Common;

public class AddAttachmentRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		AddAttachmentParamModel addAttachmentParamModel=new AddAttachmentParamModel();
		SimpleDateFormat dsf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName=dsf.format(new Date())+".jpg";
		addAttachmentParamModel.CoverImg=fileName;
		try {
			addAttachmentParamModel.AttachData=Common.getBase64EncodeString(Common.getFileByte("files//1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.paramModel=(Object)addAttachmentParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
