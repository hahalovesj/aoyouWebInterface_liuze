package com.aoyou.test.app.Result.contentModel;

import java.util.List;

public class GetMemberPointAllDataInfoModel {

	public int TotalPoint;
	
	public int RemainPoint;
	
	public int ExpiredPoint;
	
	public int MemberID;
	
	public List<GetMemberPointAllData_MemberPointAddDetailSimpleViewModel> addDetailSimpleViewList;

	public List<GetMemberPointAllData_MemberPointUseDetailSimpleViewModel> useDetailSimpleViewList;

	public List<GetMemberPointAllData_MemberPointAddDetailSimpleViewModel> FastExpirePointSimpleView;
}
