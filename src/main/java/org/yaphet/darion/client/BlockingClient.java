package org.yaphet.darion.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.yaphet.darion.service.ServiceConfig;

public class BlockingClient {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket();
		socket.bind(new InetSocketAddress(ServiceConfig.HOST,
				ServiceConfig.PORT));

		InputStream inputStream = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				inputStream));

		OutputStream outputStream = socket.getOutputStream();
		PrintWriter writer = new PrintWriter(outputStream);

		String line;
		BufferedReader systemReader = new SystemInputReader().newInstance();
		while ((line = systemReader.readLine()) != "end") {
			System.out.println("Reading From System Input : " + line);
			writer.write(line);
			writer.flush();
			String socketInput = reader.readLine();
			System.out.println("Receive From Socket : " + socketInput);
		}

		writer.close();
		outputStream.close();
		reader.close();
		inputStream.close();

		socket.close();
	}

}
