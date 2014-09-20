package org.darion.thread;

public class ThreadTest {

	static int counter = 0;

	public static void main(String[] args) {

		Runnable runnable = new Runnable() {
			public void run() {
				// for (int index = 0; index <= 10; index++) {
				// counter += index;
				// }
				// System.out.println(Thread.currentThread() + " : " + counter);
				Count count = new Count();
				count.count();
			}
		};

		for (int i = 0; i < 10; i++) {
			new Thread(runnable).start();
		}
	}
}