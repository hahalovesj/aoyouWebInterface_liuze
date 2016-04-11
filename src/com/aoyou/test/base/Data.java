package com.aoyou.test.base;

import java.util.ArrayList;
import java.util.List;


/* 框架代码中用的公共数据模块
 * 
 * 
 * 
 * */ 

public class Data {
	
	public static String currentClassName=null;  //记载了当前正在运行的类名，实际就是当前运行的case名称,在每个case开始前要修改此字段值!	
	public static List<String> reporterLog = new ArrayList<String>();
}



