package com.aoyou.test.util;

public class Random {
	
	/** 
	 * ���ָ����Χ��N�����ظ����� 
	 * ���������ķ��� 
	 * @param min ָ����Χ��Сֵ (����)
	 * @param max ָ����Χ���ֵ (����)
	 * @param n ��������� 
	 */  
	public static int[] randomCommon(int min, int max, int n){  
	    if (n > (max - min + 1) || max < min) {  
	           return null;  
	       }  
	    int[] result = new int[n];  
	    int count = 0;  
	    while(count < n) {  
	        int num = (int) (Math.random() * ((max+1) - min)) + min;  
	        boolean flag = true;  
	        for (int j = 0; j < n; j++) {  
	            if(num == result[j]){  
	                flag = false;  
	                break;  
	            }  
	        }  
	        if(flag){  
	            result[count] = num;  
	            count++;  
	        }  
	    }  
	    return result;  
	}  
	
	public static int randomCommon(int min, int max){  
	    int num = (int) (Math.random() * ((max+1) - min)) + min;  
	    return num;  
	} 

}