package org.darion.commons;

public class ClassLoader {
	private static final String CLASS_NAME = "java.lang.String";

	public static void main(String[] args) {
		try {
			Class.forName(CLASS_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
