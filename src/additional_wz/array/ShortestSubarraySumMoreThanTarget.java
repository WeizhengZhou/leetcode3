package array;

public class ShortestSubarraySumMoreThanTarget {
	public int compute(int[] A, int target){
		int l = 0;
		int r = 1;
		int curSum = A[0];
		int minLength = Integer.MAX_VALUE;
		while(r < A.length){
			System.out.println("l = " + l + ", r = " + r + ", curSum = " + curSum);
			while(l<r && curSum - A[l] > target){
				curSum -=A[l++];
				minLength = Math.min(minLength,r-l);
			}
			curSum += A[r++];
		}
		while(l<r && curSum - A[l] > target){
			curSum -=A[l];
			l++;
		    minLength = Math.min(minLength,r-l);
		}
		System.out.println("l = " + l + ", r = " + r);
		return minLength;
	}
	public static void main(String[] args){
		int[] A = new int[]{2,1,1,4,3,6};
		int target = 8;
		ShortestSubarraySumMoreThanTarget solu = new ShortestSubarraySumMoreThanTarget();
		System.out.println(solu.compute(A, target));
	}

}
