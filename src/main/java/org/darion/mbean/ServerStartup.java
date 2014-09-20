package org.darion.mbean;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class ServerStartup {

	public static void main(String[] args) throws Exception {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName(
				"org.darion.mbean:type=ServerConfigure");
		ServerConfigure mbean = new ServerConfigure();
		mbs.registerMBean(mbean, name);
		ServerConfigureNotificationListener listener = new ServerConfigureNotificationListener();
		mbs.addNotificationListener(name, listener, null, null);
		Thread.sleep(1000*120);
	}
}