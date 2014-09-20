package org.darion.aio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Date;

public class ChannelTransferServer {
	public static void main(String[] args) throws IOException {
		System.out.println(new Date());
		File sourceFile = new File(
				"/Users/2011204/source/ubuntu-14.04-desktop-i386.iso");
		File targetFile = new File("/tmp/target.iso");

		FileInputStream inputStream = new FileInputStream(sourceFile);
		FileOutputStream outputStream = new FileOutputStream(targetFile);

		FileChannel inputChannel = inputStream.getChannel();
		FileChannel outputChannel = outputStream.getChannel();

		try {
			inputChannel.transferTo(0, inputChannel.size(), outputChannel);
		} catch (IOException e) {
			e.printStackTrace();
		}

		inputChannel.close();
		outputChannel.close();
		inputStream.close();
		outputStream.close();	
		System.out.println(new Date());
	}
}
