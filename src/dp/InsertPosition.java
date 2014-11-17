package dp;

public class InsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int searchInsert(int[] A, int target) {
        if (A==null||A.length==0){
        	return 0;
        }
        return helper(A,0,A.length-1,target);
        
    }
    public int helper(int[] A, int l, int r, int target){
    	if (l==r){
    		if (A[l]>=target){
    			return l;
    		}
    		else if(A[l]<target){
    			return l+1;
    		}
    		
    	}
    	int m=l+(r-l)/2;
    	if (A[m]==target){
    		return m;
    		
    	}
    	else if (A[m]<target){
    		if (m+1<=r)
    		{
    			return helper(A,m+1,r,target);
    		}
    		else{
    			return r+1;
    		}
    	}
    	else{
    		if (l<=m-1)
    		{
    			return helper(A,l,m-1,target);
    		}
    		else{
    			return l;
    		}
    	}
    			
    }

}
