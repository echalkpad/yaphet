package org.darion.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureExamples {
	public static void main(String[] args) throws InterruptedException,
			ExecutionException, TimeoutException {

		ExecutorService service = Executors.newCachedThreadPool();
		Future<Long> future = service.submit(new Callable<Long>() {
			@Override
			public Long call() throws Exception {
				// Thread.sleep(1000 * 3);
				return System.currentTimeMillis();
			}
		});

		long result = future.get(1, TimeUnit.SECONDS);
		System.out.println(result);
		if (future.isDone()) {
			System.out.println("Done");
		}
		if (!future.isCancelled()) {
			System.out.println("No Cancelled");
		}
		System.out.println("Service Close ... ");
		service.shutdown();
	}
}
