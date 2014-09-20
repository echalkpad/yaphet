package org.darion.thread;

public class GetSerialNumThread implements Runnable {

	public static void main(String args[]) {

		GetSerialNumThread serialNumGetter = new GetSerialNumThread();
		Thread t1 = new Thread(serialNumGetter, "Thread A");
		Thread t2 = new Thread(serialNumGetter, "Thread B");
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}

	public void run() {
		int mySerialNum = getSerialNum();
		System.out.println("线程 " + Thread.currentThread().getName()
				+ " 获取到的序列号是" + mySerialNum);
		System.out.println("线程 " + Thread.currentThread().getName()
				+ " 修改了序列号为" + (mySerialNum * 3));
		setSerialNum(mySerialNum * 3);
		System.out.println("线程 " + Thread.currentThread().getName()
				+ " 再次获得的序列号是" + getSerialNum());
	}

	private int getSerialNum() {
		return SerialNum.get();
	}

	private void setSerialNum(int newSerialNum) {
		SerialNum.set(new Integer(newSerialNum));
	}
}