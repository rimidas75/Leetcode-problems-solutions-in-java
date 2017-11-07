package edu.buffalo.liveramp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		List<LinkedList<Integer>> ll = new ArrayList<LinkedList<Integer>>();
		LinkedList<Integer> l = new LinkedList<Integer>();
		ll.add(l);
		l.add(1);
		System.out.println(ll);
	}

}
