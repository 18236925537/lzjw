package com.telecomyt.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
* @author zpb
* @date 2018年1月17日 上午10:43:15 
* 类说明  时间转换
*/
public class DateUtils {
	
	/**
	 * 把时间转化为字符串
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return format.format(date);
	}
	
}
