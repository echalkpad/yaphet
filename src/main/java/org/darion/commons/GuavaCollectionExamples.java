package org.darion.commons;

import java.net.URLClassLoader;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.reflect.Reflection;
import com.google.common.reflect.TypeToken;

public class GuavaCollectionExamples {
	private static class user {
		private String name;
		private Integer id;
	}

	public static void main(String[] args) {
		BiMap<String, Integer> user2ID = HashBiMap.create();
		user2ID.put("one", 1);
		user2ID.put("two", 2);
		user2ID.put("three", 3);

		String user = user2ID.inverse().get(1);
		System.out.println("user name : " + user);
		// //////////////////////////////////////////////////////
		TypeToken<String> token;
		Reflection.initialize(user.getClass());
		
	}
}
