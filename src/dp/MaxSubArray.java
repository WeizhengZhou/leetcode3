package dp;

public class MaxSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	public int maxSubArray(int[] A){
		int max=Integer.MIN_VALUE;
		int sum=0;
		for(int i=0;i<A.length;i++){
			sum=Math.max(sum+A[i], A[i]);
			if(sum>max){
				max=sum;
				
			}
		}
		return max;
	}

}
