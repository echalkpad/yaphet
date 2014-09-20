package org.yaphet.darion.service;

public class FileOutputHandler<String> implements Handler<String> {
	private String path;

	public FileOutputHandler(String path) {
		this.path = path;
	}

	@Override
	public void handler(String data) {
		
	}

}
