package com.aoyou.test.app.Result.model;

public class test {
	
	public static void main(String[] args) {
		
//		String content=getWordText("files/1.docx");
//		
//		String[] lines=content.split("\n");
//		
//		for(String s:lines){
//			if(s.startsWith("访问地址")&&s.length()>5){
//				s=s.substring(s.indexOf("/"), s.contains("?")?s.indexOf("?"):s.length());
//				s=s.replace(" ", "");
//				System.out.println(s);
//			}
//		}
//		FileReader fr=new FileReader("files/1.txt");
//		@SuppressWarnings("resource")
//		BufferedReader br=new BufferedReader(fr);
//		String line="";
//		while((line=br.readLine())!=null){
//			if(line.endsWith("/")){
//				line=line.substring(0, line.length()-1);
//			}
//			String method=line.substring(line.lastIndexOf("/")+1,line.length());
//			
//			System.out.println("\n<method description=\"\" name=\""+method+"\" resource=\""+line+"\"/>");
//		}
	}	
	
	
//	public static String getTestsFromPackage(){
//		String beforeString ="com.aoyou.test.app35.testcases";
//		StringBuffer sb=new StringBuffer("<test name=\"App3.5接口\" preserve-order=\"true\"><classes>");
//		
//		File file=new File("E://中青旅项目//接口自动化//接口自动化项目//接口自动化改造//AoYouInterface//src//com//aoyou//test//app35//testcases");
//		
//		File[] files=file.listFiles();
//		for(int i=0;i<files.length;i++){
//			sb.append("<class name=\""+beforeString+".");
//			String name=files[i].getName();
//			name=name.substring(0, name.lastIndexOf("."));
//			sb.append(name+"\"/>");		
//		}
//		
//		sb.append("</classes></test>");
//		
//		return sb.toString();
//	}
//	
	/**获取word内容
	 * @throws IOException 
	 * @throws OpenXML4JException 
	 * @throws XmlException **/
//	public static String getWordText(String filePath) throws IOException, XmlException, OpenXML4JException{
//
////			 	OPCPackage opcPackage = POIXMLDocument.openPackage(filePath);
////	            POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
////	            String text2007 = extractor.getText();
////	            //System.out.println(text2007);
////	            return text2007;
//	}
	
}

