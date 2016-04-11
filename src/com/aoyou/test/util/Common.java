package com.aoyou.test.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.io.File;

import sun.misc.BASE64Encoder;

import com.google.gson.*;

//import sun.misc.BASE64Encoder;

public class Common {

	public static String[] getClassFields(Object o){
		if(null!=o){
			Class<?> clz=o.getClass();
			Field[] fields=clz.getDeclaredFields();
			if(fields.length>0){
				String[] fieldList=new String[fields.length];
				for(int i=0;i<fields.length;i++){
					fieldList[i]=fields[i].getName();
				}
				return fieldList;
			}else return null;
		}else return null;
	}
	
	/** 获取正确格式的接口uri
	 * @param url config文件中接口地址
	 * @param resource config文件汇总资源uri
	 * @return 格式化的uri地址
	 */
	public static String getFormatUriString(String url,String resource){
		String uri="";
		
		if(url.endsWith("/")){
			//length>4 限制url至少以http://开头
			if(url.length()>7){
				url=url.substring(0, url.lastIndexOf("/"));
			}else{
				System.out.println("url长度不正确，请检查，当前url为："+url);
			}
		}
		
		if(resource.startsWith("/")){
			resource=resource.substring(1,resource.length());
		}
		
		uri=url+"/"+resource;
		
		return uri;
	}
	
	/**创建随机设备编号**/
	public static String getDeviceID(){
		StringBuffer sb = new StringBuffer("ffffffff-");
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
		  Random random = new Random();		      
		    for (int i = 0; i <14; i++) { 
		    	if(i==4||i==9){sb.append("-");}else{
		        int number = random.nextInt(base.length());     
		        sb.append(base.charAt(number)); }    
		    } 
		sb.append("-ffff822e8fa8");
		return sb.toString();
	}
	
	/**解码json中带的unicode编码**/
	public static String decodeUnicode(String theString) {  
        char aChar;  
        int len = theString.length();  
        StringBuffer outBuffer = new StringBuffer(len);  
        for (int x = 0; x < len;) {  
            aChar = theString.charAt(x++);  
            //if (aChar == '\\') {  
                aChar = theString.charAt(x++);  
                if (aChar == 'u') {  
                    // Read the xxxx  
                    int value = 0;  
                    for (int i = 0; i < 4; i++) {  
                        aChar = theString.charAt(x++);  
                        switch (aChar) {  
                        case '0':  
                        case '1':  
                        case '2':  
                        case '3':  
                        case '4':  
                        case '5':  
                        case '6':  
                        case '7':  
                        case '8':  
                        case '9':  
                            value = (value << 4) + aChar - '0';  
                            break;  
                        case 'a':  
                        case 'b':  
                        case 'c':  
                        case 'd':  
                        case 'e':  
                        case 'f':  
                            value = (value << 4) + 10 + aChar - 'a';  
                            break;  
                        case 'A':  
                        case 'B':  
                        case 'C':  
                        case 'D':  
                        case 'E':  
                        case 'F':  
                            value = (value << 4) + 10 + aChar - 'A';  
                            break;  
                        default:  
                            throw new IllegalArgumentException(  
                                    "Malformed   \\uxxxx   encoding.");  
                        }  
      
                    }  
                    outBuffer.append((char) value);  
                } else {  
                    if (aChar == 't')  
                        aChar = '\t';  
                    else if (aChar == 'r')  
                        aChar = '\r';  
                    else if (aChar == 'n')  
                        aChar = '\n';  
                    else if (aChar == 'f')  
                        aChar = '\f';  
                    outBuffer.append(aChar);  
                }  
//            } else  
//                outBuffer.append(aChar);  
        }  
        return outBuffer.toString();  
    }
	
	 public static String htmlEncode(String source) {
	        if (source == null) {
	            return "";
	        }
	        String html = "";
	        StringBuffer buffer = new StringBuffer();
	        for (int i = 0; i < source.length(); i++) {
	            char c = source.charAt(i);
	            switch (c) {
	            case '<':
	                buffer.append("&lt;");
	                break;
	            case '>':
	                buffer.append("&gt;");
	                break;
	            case '&':
	                buffer.append("&amp;");
	                break;
	            case '"':
	                buffer.append("&quot;");
	                break;
	            case 13:
	                break;
	            default:
	                buffer.append(c);
	            }
	        }
	        html = buffer.toString();
	        return html;
	    }
	 
	 
	 /**将回传json转换成结果对象返回
	* @param cls 结果对象模型**/
	public static <T> T getResultMode(String responseString,Class<T> cls){
		T t=null;
		Gson gson=new Gson();
		try{
			t=gson.fromJson(responseString, cls);
		}catch (Exception e) {
           
        }
		return t;
	}
	
	//将文件转成byte数组
	public static byte[] getFileByte(String filePath) throws IOException{
		byte[] bs=null;
		InputStream in=null;
		File file=new File(filePath);
		try {
			in=new FileInputStream(file);
			bs=new byte[(int)file.length()];
			in.read(bs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();
		return bs;
	}
	
	/** byte[] 转 base64编码
	 * **/
	public static String getBase64EncodeString(byte[] bytes){
		BASE64Encoder base=new BASE64Encoder();
		return base.encode(bytes);
	}
	
	/**根据格式返回当前时间字符串
	 * **/
	public static String getDataStringByFormat(String format){
		String dateString="";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		dateString=sdf.format(new Date());
		return dateString;
	}
	
	/**转换时间戳为时间**/
	public static Date getDate(String timeStamp){
		timeStamp=timeStamp.substring(timeStamp.indexOf("(")+1, timeStamp.lastIndexOf(")"));
		return new Date(Long.parseLong(timeStamp));
	}
}
