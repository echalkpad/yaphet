package org.darion.mbean;

public class Echo implements EchoMBean {

	public void print(String name) {
		System.out.println("Hello " + name);
	}

}
