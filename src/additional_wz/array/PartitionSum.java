package array;

import java.util.Arrays;

public class PartitionSum {
	public int solve(int[] A){
		if(A == null || A.length < 1) return 0;
		Arrays.sort(A);
		int i=0;
		int minSum = 0;
		
		if(A.length%2 == 1){
			i++;
			minSum += A[0];
		}
		
		while(i<A.length){
			System.out.println("i = " + i + ", minSum = " + minSum);
			minSum = minSum*10 + A[i] + A[i+1];
			i=i+2;
		}
		return minSum;
	}
	public static void main(String[] args){
		int[] A = new int[]{1,2,7,8,9};
		PartitionSum solu = new PartitionSum();
		System.out.println(solu.solve(A));
		
	}

}
