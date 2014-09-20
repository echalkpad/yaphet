package org.darion.fun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main_1020 {
	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in, "ISO-8859-1"));

		try {
			int size = Integer.valueOf(reader.readLine());
			for (int index = 0; index < size; index++) {
				String line = reader.readLine();
				Map<Character, Integer> map = new TreeMap<Character, Integer>();

				for (int position = 0; position < line.length(); position++) {
					Character character = line.charAt(position);
					if (map.containsKey(character)) {
						int val = map.get(character) + 1;
						map.put(character, val);
					} else {
						map.put(character, 1);
					}
				}

				for (Character character : map.keySet()) {
					if (map.get(character) != 1)
						System.out.print(map.get(character));
					System.out.print(character);
				}
				System.out.println();
			}
		} finally {
			reader.close();
		}
	}
}
