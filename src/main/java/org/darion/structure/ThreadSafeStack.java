package org.darion.structure;

public class ThreadSafeStack {
	private String[] array;

	public ThreadSafeStack() {
		array = new String[16];
	}

	public ThreadSafeStack(int size) {
		array = new String[size];
	}
	
	

	public static void main(String[] args) {

	}
}
