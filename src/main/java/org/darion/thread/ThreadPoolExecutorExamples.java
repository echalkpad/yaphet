package org.darion.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExamples {
	public static void main(String[] args) {
		int corePoolSize = Runtime.getRuntime().availableProcessors();
		int maximumPoolSize = corePoolSize * 2;
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,
				maximumPoolSize, 60, TimeUnit.SECONDS, workQueue);

		for (int index = 0; index < 20; index++) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(System.currentTimeMillis());
				}
			});
		}

		executor.shutdown();
	}
}
