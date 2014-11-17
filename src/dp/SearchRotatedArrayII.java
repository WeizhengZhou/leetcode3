package dp;

public class SearchRotatedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean search(int[] A, int target) {
        if (A==null||A.length==0){
        	return false;
        }
        return helper(A,0,A.length-1,target);
    }
    public boolean helper(int[] A, int l, int r, int target){
    	if (l>r){
    		return false;
    	}
    	if (l==r){
    		if(A[l]==target){
    			return true;
    		}
    		return false;
    	}
    	int m=l+(r-l)/2;
    	if (A[m]==target){
    		return true;
    	}
    	if (A[l]<A[m]){
    		if (target<A[m]&& target>=A[l])
    		{
    			return helper(A,l,m-1,target);
    		}
    		else{
    			return helper(A,m+1,r,target);
    		}    		
    	}
    	else if (A[l]>A[m]){
    		if (target>A[m]&&target<=A[r])
    		{
    			return helper(A,m+1,r,target);
    		}
    		else{
    			return helper(A,l,m-1,target);
    		}
    	}
    	else{
    		boolean left=helper(A,l,m-1,target);
    		return left?true:helper(A,m+1,r,target);
    	}
    	
    }

}
