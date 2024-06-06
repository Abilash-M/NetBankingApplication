//$Id$
package com.letsCode.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class AccountService {
	public static <E> String mapToJson(ArrayList<E> object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}
	
	public static String mapToJson(HashMap<Integer, String> map) {
		JsonObject jsonObject = new JsonObject();
		for(Map.Entry<Integer, String> m: map.entrySet()) {
			jsonObject.addProperty(m.getKey().toString(), m.getValue());
		}
		System.out.println(jsonObject);
		return jsonObject.toString();
	}
	
	public static String mapToJson(Object object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}
	
}

