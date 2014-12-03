package array;

import java.util.*;

public class KthSumOfTwoArray {
	public int kthSum(int[] A, int[] B, int k){
		if(A == null || B == null) return -1;
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(0,0,A[0]+B[0]));
		for(int i=0;i<k;i++){
			Pair minPair = pq.remove();		
			System.out.println(minPair.value);
			pq.add(new Pair(minPair.i+1,minPair.j,A[minPair.i+1]+B[minPair.j]));
			pq.add(new Pair(minPair.i,minPair.j+1,A[minPair.i]+B[minPair.j+1]));			
		}
		return 1;
	}
	public static void main(String[] args){
		int[] A = new int[]{1,5,7};
		int[] B = new int[]{2,4,10};
		KthSumOfTwoArray solu = new KthSumOfTwoArray();
		System.out.println(solu.kthSum(A, B, 5));
		
	}
}
class Pair implements Comparable{
	int value = 0;
	int i = 0;
	int j = 0;
	public Pair(int i, int j, int value){
		this.i = i;
		this.j = j;
		this.value  = value;
	}
	@Override 
	public int compareTo(Object o){
		Pair other = (Pair) o;
		return this.value - other.value;
	}
}
