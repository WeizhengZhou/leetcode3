package priorityQueue;
import java.util.*;
public class PriorityQueueTest{
	public static void main(String[] args){
		MaxHeap<Integer> maxHeap = new MaxHeap<>(10);
		for(int i=0;i<10;i++)
			maxHeap.add(i);
		System.out.println(maxHeap);
//		System.out.println(maxHeap.size());
		for(int i=0;i<10;i++){
			maxHeap.remove();
			System.out.println(maxHeap);
		}
		
	
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
