package array;

import java.util.*;
public class FirstRepeatElement {
	public int firstRepeat(int[] A){
		if(A == null) return -1;		
		for(int i=0;i<A.length;i++){
			if(A[i] > 0 && A[i] < A.length){
				if(i == A[i]-1)
					continue;
				else if(A[A[i]-1] == A[i])
					A[A[i]-1] = -A[i];
				else{
					swap(A,A[i]-1,i);
				}
			}
			System.out.println("i = " + i + ", A = " + Arrays.toString(A));
		}
		for(int i=0;i<A.length;i++)
			if(A[i] < 0)
				return -A[i];
		return -1;
	}
	private void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	public static void main(String[] args){
		FirstRepeatElement  solu = new FirstRepeatElement ();
		int[] A = new int[]{6,5,4,3,2,1,5,2};
		System.out.println(solu.firstRepeat(A));
	}
}
