package array;

import java.util.Arrays;
public class WaveLikeArray {
	public static void main(String[] args){
		int[] A = new int[]{1,2,3,4,5};
		for(int i=0;i<A.length-1;i++){
			if((i&1) == 0 && A[i] < A[i+1]){
				int temp = A[i];
				A[i] = A[i+1];
				A[i+1] = temp;
			}
			if((i&1) != 0 && A[i] > A[i+1]){
				int temp = A[i];
				A[i] = A[i+1];
				A[i+1] = temp;
			}			
		}
		System.out.println(Arrays.toString(A));
	}
}
