package array;

import java.util.Arrays;

public class ThreeIncreasing {
	public void compute(int[] A){
		if(A == null) return;
		int[] min = new int[A.length];
		int[] max = new int[A.length];
		min[0] = 0;
		for(int i=1;i<A.length;i++){
			min[i] = A[i] < A[min[i-1]] ? i:min[i-1];
		}
		max[A.length-1] = A.length-1;
		for(int i=A.length-2;i>=0;i--){
			max[i] = A[i] > A[max[i+1]] ? i:max[i+1];
		}
		for(int i=0;i<A.length;i++){
			if(i != min[i] && i != max[i])
				System.out.println("i = " + min[i] + ", j = " + i + ", k = " + max[i]);
		}
		System.out.println(Arrays.toString(min));
		System.out.println(Arrays.toString(max));
	}
	public static void main(String[] args){
		ThreeIncreasing solu = new ThreeIncreasing();
		int[] A = new int[]{2,1,3,4};
		solu.compute(A);
	}

}
