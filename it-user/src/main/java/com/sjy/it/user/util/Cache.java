package com.sjy.it.user.util;

import java.util.concurrent.ConcurrentHashMap;

public class Cache {
	private static ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>(32);
	public static void put(String key,Object value) {
		map.put(key, value);
	}
	public static Object get(String key) {
		return map.get(key);
	}

}
