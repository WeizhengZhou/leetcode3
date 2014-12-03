package array;

import java.util.*;

public class SortArrayLexiOrder{
	public int[] sortLexiOrder(int[] A){
		if(A == null || A.length <2) return A; 
		String[] strs = new String[A.length];
		for(int i=0;i<A.length;i++){
			strs[i] = A[i] + "";
		}
		Arrays.sort(strs,new Comparator<String>(){//only two arrangements, compare a+b and b+a, see which combination has lower order
			@Override
			public int compare(String a, String b){
				String ab = a+b;
				String ba = b+a;
				return -ab.compareTo(ba);		
			}	
		});
		for(int i=0;i<A.length;i++){
			A[i] = Integer.parseInt(strs[i]);
		}
		return A;
	}
	public static void main(String[] arga){
		SortArrayLexiOrder solu = new SortArrayLexiOrder();
		int[] A = new int[]{4, 94, 9, 14, 1};
		A = solu.sortLexiOrder(A);
		System.out.println(Arrays.toString(A));
		
	}
}
