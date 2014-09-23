package org.darion.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TelnetExamples {
	public static void main(String[] args) throws IOException {
		System.out.println("Start Telnent Examples .... ");
		ServerSocket serverSocket = new ServerSocket(8989);
		Socket socket = serverSocket.accept();
		while (true) {
			InputStream inputStream = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			String line = reader.readLine();
			if (line != null || line.length() != 0) {
				System.out.println(line);
			}
		}
	}
}
