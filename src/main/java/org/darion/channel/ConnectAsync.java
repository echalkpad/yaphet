package org.darion.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectAsync {
	public static void main(String[] args) throws IOException {
		InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8989);
		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);
		channel.connect(address);
		
	}
}
