package org.yaphet.darion;

public class BasicGenerator<T> implements Generator<T> {

	private Class<T> clazz;

	public BasicGenerator(Class<T> typeClass) {
		clazz = typeClass;
	}

	public T next() {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public static <T> Generator<T> create(Class<T> typeClass) {
		return new BasicGenerator<T>(typeClass);
	}
}
