package com.core;

import org.aspectj.lang.JoinPoint;

public class DataSourceInterceptor {

	public void setdataSourceMysql(JoinPoint jp) {
		DatabaseContextHolder.setCustomerType("dataSourceMySql");
	}
	
	public void setdataSourceOracle(JoinPoint jp) {
		DatabaseContextHolder.setCustomerType("dataSourceOracle");
	}
}