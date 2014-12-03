package treeSet;

import java.util.*;
public class TreeSetTest {
	public static void main(String[] args){
		TreeSet<Integer> tset = new TreeSet<>(Collections.reverseOrder());
		tset.add(6);
		tset.add(1);
		tset.add(3);
		tset.add(10);
		tset.add(8);
		System.out.println(tset);
		System.out.println(tset.first());
		System.out.println(tset.last());
		tset.pollFirst();
		tset.pollLast();
		System.out.println(tset.first());
		System.out.println(tset.last());
	}
}
