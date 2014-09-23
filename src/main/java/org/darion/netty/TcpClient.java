package org.darion.netty;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {

	public static void main(String[] args) throws IOException,
			InterruptedException {

		Socket socket = null;
		OutputStream out = null;
		InputStream in = null;

		try {

			socket = new Socket("localhost", 8080);
			out = socket.getOutputStream();
			in = socket.getInputStream();

			// ?????
			out.write("第一次请求".getBytes("UTF-8"));
			out.flush();

			// ??????????
			byte[] byteArray = new byte[1024];
			int length = in.read(byteArray);
			System.out.println(new String(byteArray, 0, length, "UTF-8"));

			Thread.sleep(5000);

			// ???????
			out.write("第二次请求".getBytes("UTF-8"));
			out.flush();

			// ????????????
			byteArray = new byte[1024];
			length = in.read(byteArray);
			System.out.println(new String(byteArray, 0, length, "UTF-8"));

		} finally {
			// ????
			in.close();
			out.close();
			socket.close();
		}

	}

}