package org.darion.structure;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExamples {
	public static void main(String[] args) {
		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
		for (int index = 0; index < 10; index++) {
			list.add(index);
		}

		for (Integer i : list)
			System.out.println(i);
	}
}
