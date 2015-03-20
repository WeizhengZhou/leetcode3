package xx;

public class MaxProductSubarray {
	 public int maxProduct(int[] A) {
	        if(A==null || A.length==0)return 0;
	        int maxSoFar=A[0];
	        int curMax=1;
	        int curMin=1;
	        for(int i=0;i<A.length;i++){
	            if(A[i]==0){
	                maxSoFar=Math.max(maxSoFar,0);
	                curMax=1;
	                curMin=1;
	            }
	            else if(A[i]>0){
	                curMax*=A[i];
	                curMin*=A[i];
	                maxSoFar=Math.max(maxSoFar,curMax);
	                curMin=Math.min(1,curMin);
	            }
	            else{
	                int preCurMax=curMax;
	                curMax=curMin*A[i];
	                curMin=preCurMax*A[i];
	                maxSoFar=Math.max(maxSoFar,curMax);
	                curMax=Math.max(curMax,1);
	            }
	        }
	        return maxSoFar;
	    }
}
