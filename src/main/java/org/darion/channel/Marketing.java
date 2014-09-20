package org.darion.channel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.GatheringByteChannel;

public class Marketing {
	private static final String PATH = "/Users/2011204/mob_app.log";

	public static void main(String[] args) throws FileNotFoundException {
		FileOutputStream outputStream = new FileOutputStream(new File(
				"/tmp/target"));
		GatheringByteChannel channel = outputStream.getChannel();
		
	}
}
