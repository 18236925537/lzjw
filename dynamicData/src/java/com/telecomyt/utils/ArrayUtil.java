package com.telecomyt.utils;

import java.util.Arrays;

public class ArrayUtil {
	
	public static String sort(String path){
		String pathNew = "";
		String [] path1 = path.split(">>");
		String temp = "";
		for(int i = 0;i < path1.length;i++){
			for(int j = 0;j < path1.length-i-1;j++){
				temp = path1[j];
				path1[j] = path1[j+1];
				path1[j+1] = temp;
			}
		}
		//拼接字符串
		for(int i = 0;i < path1.length;i++){
			if(i == path1.length-1){
				pathNew += path1[i];
			}else{
				pathNew += path1[i] + ">>";
			}
		}
		return pathNew;
	}
	
	/**
	 * correctString(核对时间)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月26日 下午4:33:37    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月26日 下午4:33:37    
	 * 修改备注： 
	 * @param time
	 * @return
	 */
	public static String [] correctString(String [] time){
		String [] times = new String[3];;
		for(int i = 0;i < time.length;i++){
			if(time[i].length() < 2){
				time[i] = "0"+ time[i];
			}
			times[i] = time[i];
		}
		return times;
	}
	
	/**
	 * correctListTime(格式化标题时间)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月26日 下午5:22:27    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月26日 下午5:22:27    
	 * 修改备注： 
	 * @param time
	 * @return
	 */
	public static String [] correctListTime(String time){
		String [] correctedTime = new String[3];
		String [] times = new String[3];
		if(time != null && !time.equals("")){
			//time 类似 2018-6-8 ==> 2018-06-08
			if(time.split("/").length > 2){
				times = time.split("/");
			}else if(time.split("-").length > 2){
				times = time.split("-");
			}
			//核对每个地方是否是两位的
			for(int i = 0;i < times.length;i++){
				if(times[i].length() < 2){
					times[i] = "0"+ times[i];
				}
				correctedTime[i] = times[i]; 
			}
		}
		return correctedTime;
	}
	
	public static String correctPoliceNumber(String number){
		String a = "000000";
		if(number.length() < 6){
			a = a.substring(0,6-number.length()) + number;
		}
		return a;
	}
	
	public static String correctNumber(String number){
		String a = "0000";
		if(number.length() < 4){
			a = a.substring(0,4-number.length()) + number;
		}
		return a;
	}
	
	public static String correctIdentityCard(String number){
		String card = number.substring(0,number.lastIndexOf("x"));
		return card+"X";
	}
	
	public static void main(String[] args) {
		String[] correctListTime = correctListTime("2018-2-1");
		System.out.println(Arrays.toString(correctListTime));
	}
}
