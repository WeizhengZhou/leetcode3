package array;

import java.util.*;
public class MinRangeCoverKArrays{
	public void findMinRange(List<List<Integer>> lists){
		


	}
}
class Node implements Comparable{
	int key = 0;
	Iterator iter = null;
	@Override
	public int compareTo(Object o) {
		if(!(o instanceof Node)) return -1;
		Node other = (Node) o;
		return this.key - other.key;
	}
}
class MinHeap<T extends Comparable<T>> extends Heap<T>{
	MinHeap(int capacity){
		super(capacity,new Comparator<T>(){
			@Override
			public int compare(T t1, T t2){
				return t1.compareTo(t2);
			}
		});
	}
}
class MaxHeap<T extends Comparable<T>> extends Heap<T>{
	MaxHeap(int capacity){	
		super(capacity,new Comparator<T>(){
			@Override
			public int compare(T t1, T t2){
				return -t1.compareTo(t2);
			}
		});
	}
	
}
abstract class Heap<T extends Comparable<T>>{
	PriorityQueue<T> pq = null;
	Heap(int capacity, Comparator<T> comparator){
		pq = new PriorityQueue<T>(capacity, comparator);
	}
	public void add(T t){
		pq.add(t);
	} 
	public void remove(){
		pq.remove();
	}
	public int size(){
		return pq.size();
	}
	public boolean isEmpty(){
		return pq.isEmpty();
	}
	public String toString(){
		return pq.toString();
	}
}

