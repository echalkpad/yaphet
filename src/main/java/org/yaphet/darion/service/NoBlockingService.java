package org.yaphet.darion.service;

import static java.nio.channels.SelectionKey.OP_READ;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NoBlockingService extends AbstractService {
	private Map<SocketChannel, ByteBuffer> sendChannelMap;
	private Map<SocketChannel, ByteBuffer> reveChannelMap;

	private Selector selector;
	private ServerSocketChannel serverSocketChannel;
	private static final SocketAddress ADDRESS = new InetSocketAddress(
			"127.0.0.1", 8989);

	private volatile boolean running = true;

	public NoBlockingService() {
		sendChannelMap = new ConcurrentHashMap<SocketChannel, ByteBuffer>();
		reveChannelMap = new ConcurrentHashMap<SocketChannel, ByteBuffer>();

		try {
			selector = Selector.open();

			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.bind(ADDRESS);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		} catch (IOException e) {
			System.err.println("NoBlocking Service Create Failed : "
					+ e.getMessage());
		}

	}

	@Override
	public void startup() {
		while (running) {
			try {
				int size = selector.select();
				System.out.println("Key set : " + size);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Iterator<SelectionKey> keyIterator = selector.selectedKeys()
					.iterator();

			while (keyIterator.hasNext()) {
				SelectionKey key = keyIterator.next();
				if (!key.isValid()) {
					continue;
				}

				if (key.isAcceptable()) {
					doAccept(key);
				}

				if (key.isReadable()) {
					doRead(key);
				}

				if (key.isWritable()) {
					doWrite(key);
				}

				keyIterator.remove();
			}
		}
	}

	@Override
	public void stop() {
		if (selector.isOpen()) {
			try {
				selector.close();
			} catch (IOException e) {
				System.err.println("Selector Close Failed : " + e.getMessage());
			}
		}

		for (SocketChannel channel : sendChannelMap.keySet()) {
			if (channel.isOpen()) {
				try {
					channel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		for (SocketChannel channel : reveChannelMap.keySet()) {
			if (channel.isOpen()) {
				try {
					channel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void doRead(SelectionKey key) {
		ByteBuffer sizeBuffer = ByteBuffer.allocate(4);
		SocketChannel channel = (SocketChannel) key.channel();
		if (reveChannelMap.containsKey(channel)) {

		} else {
			int size = 0;
			try {
				size = channel.read(sizeBuffer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(size);
		}
	}

	private void doWrite(SelectionKey key) {
		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buffer = sendChannelMap.get(channel);
		
		key.cancel();
	}

	private void doAccept(SelectionKey key) {
		ServerSocketChannel channel = (ServerSocketChannel) key.channel();
		SocketChannel socketChannel = null;
		try {
			socketChannel = channel.accept();
			socketChannel.configureBlocking(false);
			socketChannel.register(selector, SelectionKey.OP_READ);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Service service = new NoBlockingService();
	}

}
