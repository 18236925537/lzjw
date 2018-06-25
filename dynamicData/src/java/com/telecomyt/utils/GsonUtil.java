package com.telecomyt.utils;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.telecomyt.exception.GsonDataConvertException;

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
	public static <T> T fromJson(String jsonStr, Class<T> t) throws GsonDataConvertException {
		return getGson().fromJson(jsonStr, t);
	}

	// 将Json数组解析成相应的映射对象列表
	public static <T> List<T> parseJsonArrayWithGson(String jsonData, Class<T> type) {
		List<T> result = getGson().fromJson(jsonData, new TypeToken<List<T>>() {
		}.getType());
		return result;
	}

	// 根据key获取给定的json数据的值
	public static String getValue(String jsonStr, String key) {
		if (jsonStr != null && !jsonStr.equals("") && !jsonStr.equals("{}")) {
			// 将json字符串转为JsonObject对象
			JsonObject job = getGson().fromJson(jsonStr, JsonObject.class);
			// JsonArray jsonarray = getGson().fromJson(jsonStr,
			// JsonArray.class);
			// for (int i = 0; i < jsonarray.size(); i++) {
			// JsonObject obj = (JsonObject) jsonarray.get(i);
			// if ((obj.get("name").getAsString()).equals(key)) {
			// return obj.get("value").getAsString();
			// }
			// }
			// if ((job.get("name").getAsString()).equals(key)) {
			// return job.get("value").getAsString();
			// }
			return job.get(key).getAsString();
		}
		return null;
	}

}
