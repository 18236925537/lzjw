package com.telecomyt.utils;

import org.apache.log4j.Logger;

public class PathUtil {
	
	private static Logger logger = Logger.getLogger(PathUtil.class);
	
	/**
	 * 获取项目路径
	 * @param T
	 * @param projectName
	 * @return
	 */
	public static String getProjectPath(Class<?> T,String projectName){
		String path = T.getResource("/").toString();
		path = path.substring(0,path.indexOf(projectName))+projectName;
		path = path.substring(path.indexOf(":")+1,path.length());
//		path+="/WEB-INF/classes/setting.properties";
		path = path.replaceAll("%20", " ");
		return path;
	}
	/**
	 * 获取项目路径并添加后置路径
	 * @param T
	 * @param projectName
	 * @param appendPsth
	 * @return
	 */
	public static String getProjectPath(Class<?> T,String projectName,String appendPsth){
		String path = T.getResource("/").toString();
		path = path.substring(0,path.indexOf(projectName))+projectName;
		path = path.substring(path.indexOf(":")+1,path.length());
		path += appendPsth;
		path = path.replaceAll("%20", " ");
		return path;
	}
}
