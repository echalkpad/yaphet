package org.yaphet.darion.service;

public class PrintHandler implements Handler<String> {
	public void handler(String data) {
		System.out.println(data);
	}
}
