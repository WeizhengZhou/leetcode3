package array;

public class SubarraySumToTarget {
	public void compute(int[] A, int target){
		if(A == null) return;
		int l = 0;
		int r = 1;
		int sum = A[0];
		while(r <= A.length){	
			while(l < r && sum > target){
				sum-=A[l];
				l++;
			}
			if(sum == target){
				System.out.println("l =" + l + ", r = " + (r-1));
				return;
			}
			sum+=A[r];
			r++;
		}		
		return;
	}
	public static void main(String[] args){
		int[] A = new int[]{1,2,3,4};
		SubarraySumToTarget solu = new SubarraySumToTarget();
		solu.compute(A,9);
		
		
	}

}
