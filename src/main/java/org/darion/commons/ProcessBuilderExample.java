package org.darion.commons;

import java.io.IOException;

public class ProcessBuilderExample {
	public static void main(String[] args) {
		ProcessBuilder builder = new ProcessBuilder("");
		try {
			builder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
