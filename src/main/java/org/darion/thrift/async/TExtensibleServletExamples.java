package org.darion.thrift.async;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TExtensibleServlet;

public class TExtensibleServletExamples {
	private static class MyServlet extends TExtensibleServlet {

		@Override
		protected TProcessor getProcessor() {
			return null;
		}

		@Override
		protected TProtocolFactory getInProtocolFactory() {
			return null;
		}

		@Override
		protected TProtocolFactory getOutProtocolFactory() {
			return null;
		}
	}

	public static void main(String[] args) {
		MyServlet servlet = new MyServlet();
	}

}
