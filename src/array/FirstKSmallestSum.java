package array;
import java.util.Arrays;
import java.util.*;
public class FirstKSmallestSum{
	public int[] firstKSum(int[] A, int[] B, int k){
		if(A == null || B == null) return null;
		int m = A.length;
		int n = B.length;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] C = new int[k];
		int i = 0;
		int j = 0;
		int r = 0;
		pq.add(A[i]+B[j]);
		while(k>0){
			System.out.println("k = " + k + ", pq = " + pq + ", i = " + i + ", j = " + j);
			k--;
			C[r++] = pq.remove();
			
			pq.add(A[i+1]+B[j]);
			pq.add(A[i]+B[j]);
	
			if(i<m-1) i++;
			if(j<m-1) j++;
//			if(i == m-1 && j== n-1)
//				break;		
		}   
		return C;
	}
	public static void main(String[] args){
		FirstKSmallestSum solu = new FirstKSmallestSum();
		int[] A = new int[]{1,3,5};
		int[] B = new int[]{2,4,6};
		int[] C = solu.firstKSum(A,B,3);
		System.out.println(Arrays.toString(C));
	}

}
