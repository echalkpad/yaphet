package org.yaphet.darion.service;

import java.util.TimerTask;

public class StopTask extends TimerTask {

	private boolean stopped;

	public StopTask(boolean flag) {
		this.stopped = flag;
	}

	@Override
	public void run() {
		System.out.println("Stop Flag From False --> True ");
		this.stopped = true;
	}

}
