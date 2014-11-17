package dp;

public class SearchRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int search(int[] A, int target) {
        if (A==null||A.length==0){
        	return -1;
        }
        return helper(A,0,A.length-1,target);
    }
    public int helper(int[] A, int l, int r, int target){
    	if (l>r){
    		return -1;
    	}
    	if (l==r){
    		if(A[l]==target){
    			return l;
    		}
    		return -1;
    	}
    	int m=l+(r-l)/2;
    	if (A[m]==target){
    		return m;
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
    		if(m+1<A.length&&A[m+1]==target){
    			return m+1;
    		}
    		return -1;
    	}
    	
    }
}
