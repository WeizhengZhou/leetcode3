//zz reviewed
package zz;

public class MaxSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxSubArray(int[] A) {
        if(A==null || A.length==0){
        	return 0;
        }
        int max=Integer.MIN_VALUE;//zz max_sum_so_far
        int curSum=0;//zz cur_su
        for(int i=0;i<A.length;i++){
        	curSum+=A[i];
        	curSum=Math.max(0, curSum);
        	max=Math.max(max, curSum);
        }
        return max;
    }


}
