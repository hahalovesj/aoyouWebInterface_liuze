package com.aoyou.test.app.request;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.aoyou.test.app.Result.model.TicketSelectResult;
import com.aoyou.test.app.request.param.model.TicketPriceParamModel;
import com.aoyou.test.base.Action;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.Random;

public class TicketPriceRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		TicketSelectResult ticketSelectResult=Action.getTicketSelectResult();
		TicketPriceParamModel ticketPriceParamModel=new TicketPriceParamModel();
		int size=ticketSelectResult.Data.size();
		int index=Random.randomCommon(0, size-1);
		ticketPriceParamModel.ticketID=ticketSelectResult.Data.get(index).Attr_Tickets.get(0).TicketID;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dateString=sdf.format(new Date());
		ticketPriceParamModel.data=dateString;
		this.paramModel=ticketPriceParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.5";
	}

}
