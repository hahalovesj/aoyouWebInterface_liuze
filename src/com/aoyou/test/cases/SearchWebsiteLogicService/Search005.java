package com.aoyou.test.cases.SearchWebsiteLogicService;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aoyou.test.base.Data;
import com.aoyou.test.base.InterfaceCallException;
import com.aoyou.test.base.TestBase;
import com.aoyou.test.templates.SearchWebsiteLogicService.Search;
import com.aoyou.test.listener.TestngRetry;

/**
 * @author liuze
 * @ClassName: Search005
 * @Description: �������keyΪ�ض�ֵ���ӿڷ��ص����в�Ʒ������Ϣ
 */
public class Search005 extends TestBase{
	
	@BeforeClass  
    public void setUp(){
    	Data.currentClassName = this.getClass().getSimpleName();
    }
	
	@Test(retryAnalyzer = TestngRetry.class)	
	public void search005() throws InterruptedException{
		
		int proNumber = 0;
		int pageSize = 0;
		List<String> productName = new ArrayList<String>();
		List<String> productPrice = new ArrayList<String>();
		List<String> salePrice = new ArrayList<String>();
		List<String> imageSurl = new ArrayList<String>();
		List<String> imageMurl = new ArrayList<String>();
		List<String> imageurl  = new ArrayList<String>();

		test = new Search();
		test.setParams("Key", "1");
		test.sendPost();
		
		if(test.getStatus()==200){	
			responseString = test.getResponseString();
			px.addNameSpace("a", "http://schemas.datacontract.org/2004/07/CYTS.Aoyou.Search.WebsiteLogic.Entity");
			px.Load(responseString);
			proNumber = Integer.valueOf(px.getElementText("//a:ProductTotalCount"));
		
			if(proNumber%100!=0){
				pageSize=proNumber/100+1;
			}else{pageSize=proNumber/100;};
				
		}else{throw new InterfaceCallException("Search�ӿڵ���ʧ�ܣ�"+test.getStatus());}
			

		test.setParams("PageSize","100");
		
		//��ȡ����Ʒ��ҳ���󣬷�ҳ��ȡÿҳ��Ʒ
		for(int i=1;i<=pageSize;i++){
			test.setParams("PageIndex",i+"");
			test.sendPost();
			if(test.getStatus()==200){
				responseString = test.getResponseString();
				px.Load(responseString);
				productName.addAll(px.getElementsText("//a:ProductView//a:ProductName"));
				productPrice.addAll(px.getElementsText("//a:ProductView//a:ProductPrice"));
				salePrice.addAll(px.getElementsText("//a:ProductView//a:SalePrice"));
				imageSurl.addAll(px.getElementsText("//a:ProductView//a:ProductImageSurl"));
				imageMurl.addAll(px.getElementsText("//a:ProductView//a:ProductImageMurl"));		
				imageurl.addAll(imageSurl);
				imageurl.addAll(imageMurl);
			}else{checkPoint.isFaild("�ӿڵ�"+i+"������ʧ��!״̬�룺"+test.getStatus());}
		}

		checkPoint.notEquals(productName, "");
		checkPoint.notEquals(productName, null);
		checkPoint.notEquals(productPrice,"0.00");
		checkPoint.notEquals(productPrice,"0");
		checkPoint.notEquals(productPrice,"1.00");
		checkPoint.notEquals(productPrice,"1");
		checkPoint.notEquals(productPrice,null);
		checkPoint.notEquals(salePrice,"0.00");
		checkPoint.notEquals(salePrice,"0");
		checkPoint.notEquals(salePrice,"1.00");
		checkPoint.notEquals(salePrice,"1");
		checkPoint.notEquals(salePrice,null);
		checkPoint.notEquals(imageurl,""); 
		checkPoint.notEquals(imageurl,null); 
			
		checkPoint.result("Key:1 ���ӿڷ��ص�ȫ��"+proNumber+"��Ʒ��Ϣ��ȷ��");
	}
	
}
