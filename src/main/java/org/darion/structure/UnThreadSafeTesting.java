package org.darion.structure;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Just For Example ...
public class UnThreadSafeTesting {

	private static final int count = 1024;

	public static void main(String[] args) throws InterruptedException {
		final List<String> list = new LinkedList<String>();
		final CountDownLatch latch = new CountDownLatch(count);

		ExecutorService service = Executors.newFixedThreadPool(16);
		for (int index = 0; index < count; index++) {
			service.execute(new Runnable() {
				public void run() {
					list.add("1");
					latch.countDown();
				}
			});
		}
		latch.await();
		System.out.println(list.size());
		System.exit(0);
	}
}
