package org.darion.socket;

public class Message {
	public class Header {
		private String user;
		private String pswd;
		private long time;

		public Header setUser(String user) {
			this.user = user;
			return this;
		}

		public Header setPswd(String pswd) {
			this.pswd = pswd;
			return this;
		}

		public Header setTime(long ts) {
			this.time = ts;
			return this;
		}

		public byte[] getHeader() {
			return null;
		}
	}

	public class Body {
		private byte[] array;

		public Body setBody(byte[] array) {
			this.array = array;
			return this;
		}

		public byte[] getBody() {
			return array;
		}
	}
}
