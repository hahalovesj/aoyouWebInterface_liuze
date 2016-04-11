package com.aoyou.test.app.Result.contentModel;

import java.util.List;

public class TicketIndexInfoModel {

	public int TPID;
	
	public String Product_Name;
	
	public String Address;
	
	public double Longitude;
	
	public double Latitude;
	
	public String Attr_Tel;
	
	public String Business_Hours;
	
	public List<TicketIndex_ThemesModel> Attr_Themes;
	
	public TikcetIndex_Attr_viewModel Attr_View;
	
	public List<TicketIndex_ImageModel> Attr_Images;
	
	public double AoYou_MinPrice;
	
	public TicketIndex_NoticesModel Notice;
}
