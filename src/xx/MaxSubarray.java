package xx;

public class MaxSubarray {
	public int maxSubArray(int[] A) {
		if(A==null || A.length==0){
			return 0;
		}
		int max=Integer.MIN_VALUE;
		int curSum=0;
		for(int i=0;i<A.length;i++){
			curSum+=A[i];
			max=Math.max(max,curSum);
			curSum=Math.max(0,curSum);

		}
		return max;

	}
}
