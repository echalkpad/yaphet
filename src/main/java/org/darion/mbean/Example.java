package org.darion.mbean;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class Example {

	public static void main(String[] args) throws Exception {
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName("org.darion.mbean:type=Echo");

		Echo echo = new Echo();
		server.registerMBean(echo, name);
		server.invoke(name, "print", new Object[] { "darion.yaphet" },
				new String[] { "java.lang.String" });

		Thread.sleep(1000 * 120);
	}

}