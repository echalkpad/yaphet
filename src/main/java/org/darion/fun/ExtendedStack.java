package org.darion.fun;

import java.util.LinkedList;
import java.util.List;

public class ExtendedStack<E> implements Comparable<E>{

	private List<E> list;
	private List<E> minList;
	private List<E> maxList;
	private int index;

	public ExtendedStack() {
		index = 0;
		list = new LinkedList<E>();
		minList = new LinkedList<E>();
		maxList = new LinkedList<E>();
	}

	public void push(E element) {

	}

	public E pop() {
		return null;
	}

	public E min() {
		return null;
	}

	public E max() {
		return null;
	}

	public static void main(String[] args) {
		ExtendedStack<Integer> stack = new ExtendedStack<Integer>();
		stack.push(1);
	}

	public int compareTo(E o) {
		return 0;
	}
}
