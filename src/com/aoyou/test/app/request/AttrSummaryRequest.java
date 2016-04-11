package com.aoyou.test.app.request;

import com.aoyou.test.app.Result.model.TicketSearchResult;
import com.aoyou.test.app.request.param.model.TicketIndexParamModel;
import com.aoyou.test.base.Action;
import com.aoyou.test.templates.RestServiceTemplate;
import com.aoyou.test.util.Random;

public class AttrSummaryRequest extends RestServiceTemplate{

	@Override
	public void initParams() {
		// TODO Auto-generated method stub
		TicketSearchResult ticketSearchResult=Action.getTicketSearchResult();
		int size=ticketSearchResult.Data.TicketList.size();
		int index=Random.randomCommon(0, size-1);
		TicketIndexParamModel ticketIndexParamModel=new TicketIndexParamModel();
		ticketIndexParamModel.TPID=ticketSearchResult.Data.TicketList.get(index).TPID;
		this.paramModel=ticketIndexParamModel;
	}

	@Override
	public void setMethodVersion() {
		// TODO Auto-generated method stub
		this.version="app3.0";
	}

}
