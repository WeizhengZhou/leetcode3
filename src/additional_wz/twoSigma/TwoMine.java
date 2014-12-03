package twoSigma;

import java.util.*;
public class TwoMine {
	public void maxProfit(int[] A, int[] B){
		if(A == null || B == null || A.length != B.length) return;
		List<Node> list = new ArrayList<>();
		for(int i=0;i<A.length;i++){
			list.add(new Node(i,A[i],B[i]));
		}
		Collections.sort(list);
		for(int i=0;i<list.size();i++){
			Node n = list.get(i);
			if(i < list.size()/2){
				System.out.println("i = " + n.index + ", to mine " + "B");
			}
			else{	
				System.out.println("i = " + n.index + ", to mine " + "A");
			}		
		}
		
		System.out.println(list);		
	}
	class Node implements Comparable{
		int a = 0;
		int b = 0;
		int index = 0;
		public Node(int index, int a, int b){
			this.index = index;
			this.a = a;
			this.b = b;
		}
		@Override 
		public int compareTo(Object o){
			Node other = (Node) o;
			return (this.a-this.b) - (other.a-other.b);
		}
		public String toString(){
			return "(" + this.index + ", " + this.a + ", " + this.b + ")";
		}
	}
	public static void main(String[] args){
		TwoMine solu = new TwoMine();
		int[] A = new int[]{40, 25, 15, 50, 45, 20};
		int[] B = new int[]{15, 20, 30, 35, 10, 40};
		solu.maxProfit(A, B);
	}
}
