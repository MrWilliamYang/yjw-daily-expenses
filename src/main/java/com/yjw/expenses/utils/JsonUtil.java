package com.yjw.expenses.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json
 */
public class JsonUtil {
	
	private static ObjectMapper mapper =  new ObjectMapper();
	
	public static <T> List<T> convertCollection(String json, Class<? extends Collection> collection, Class<T> clazz){
		try {
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			com.fasterxml.jackson.databind.type.CollectionType javaType = mapper.getTypeFactory().constructCollectionType(collection, clazz);
			return mapper.readValue(json, javaType);
		} catch (Exception e) {
			//e.printStackTrace();
		} finally {
		}
		return null;
	}
	
	public static <T> T convertObject(String json, Class<T> clazz){
		try {
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(json, clazz);
		} catch (Exception e) {
			//e.printStackTrace();
		} finally {
		}
		return null;
	}
	
	public static String convertObject(Object object){
		
		try {
			return mapper.writeValueAsString(object);
		} catch (Exception e) {
			//e.printStackTrace();
		} finally {
		}
		return null;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		for (String s : list){
			if("b".equals(s)){
				list.remove(s);
				list.add("X");
			}
		}
		System.out.println(list.toString());

	}
}
