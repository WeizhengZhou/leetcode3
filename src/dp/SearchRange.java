package dp;

public class SearchRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] searchRange(int[] A, int target) {
        if (A==null||A.length==0){
        	return new int[]{-1,-1};
        }
        int start=helper(A,0,A.length-1,target,true);
        int end=helper(A,0,A.length-1,target,false);
        return new int[]{start,end};
    }
    
    public int helper(int[] A, int l, int r, int target, boolean isStart){
    	if (l>r){
    		return -1;
    	}
    	int m=l+(r-l)/2;
    	if(A[m]==target){
    		if(isStart){
	    		if(m>l && A[m-1]==target){
	    			return helper(A,l,m-1,target,isStart);
	    		}
	    		else{
	    			return m;
	    		}
    		}
    		else{
	    		if(m<r && A[m+1]==target){
	    			return helper(A,m+1,r,target,isStart);
	    		}
	    		else{
	    			return m;
	    		}
    		}
    	}
    	else if (target<A[m]){
    		return helper(A,l,m-1,target,isStart);
    	}
    	else{
    		return helper(A,m+1,r,target,isStart);
    	}
    }
}
