package org.yaphet.darion.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class SystemInputReader {
	protected BufferedReader newInstance() {
		return new BufferedReader(new InputStreamReader(System.in));
	}
}
