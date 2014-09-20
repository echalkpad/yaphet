package org.yaphet.darion.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class BlockingService implements Service {

	private static long LEAVING_TIME = 1000 * 60 * 1;// ONE MINUTE
	private static volatile boolean stopped = false;
	private ServerSocket serverSocket;

	public BlockingService() {
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(ServiceConfig.HOST,
					ServiceConfig.PORT));
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (!stopped) {
			Socket socket;
			try {
				socket = serverSocket.accept();
				InputStream input = socket.getInputStream();
				// OutputStream output = socket.getOutputStream();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(input));
				String inputString = reader.readLine();
				System.out.println("Receive Data : " + inputString);
				Handler<String> handler = new PrintHandler();
				handler.handler(inputString);
				input.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				continue;
			}
		}

		System.out.println("Stopped ...");
	}

	public void startup() {
		SimpleDateFormat format = new SimpleDateFormat(
				ServiceConfig.DATE_FORMAT);

		System.out.println("Stop at : " + format.format(new Date()));
	}

	public void stop() {

	}

	public static void main(String[] args) {
		StopTask task = new StopTask(stopped);
		Timer timer = new java.util.Timer();
		timer.schedule(task, LEAVING_TIME);
		Service service = new BlockingService();
		service.startup();
	}
}
