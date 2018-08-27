package com.telecomyt.web.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class GsonUtil {

	// 时间格式
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	// 获得Gson对象getGson
	public static Gson getGson() {
		return new GsonBuilder().setDateFormat(DATE_FORMAT).create();
	}

	// 将对象转化成json字符串形式
	public static String toJson(Object obj) {
		return getGson().toJson(obj);
	}

	// 将json转化成对象
	public static <T> T fromJson(String jsonStr, Class<T> t) throws Exception {
		return getGson().fromJson(jsonStr, t);
	}

	// 将Json数组解析成相应的映射对象列表
	public static <T> List<T> parseJsonArrayWithGson(String jsonData, Class<T> type) {
		List<T> result = getGson().fromJson(jsonData, new TypeToken<List<T>>() {
		}.getType());
		return result;
	}

}
