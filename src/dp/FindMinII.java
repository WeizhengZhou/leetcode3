package dp;

public class FindMinII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int findMin(int[] num) {
        if(num==null||num.length==0){
        	return 0;
        }
        return helper(num,0,num.length-1);
    }
    
    public int helper(int[] A, int l, int r){
    	if(l==r){
    		return A[l];
    	}
    	if(l+1==r){
    		return Math.min(A[l], A[r]);
    	}
    	int m=l+(r-l)/2;
    	if(A[m-1]>A[m]){
    		return A[m];
    	}
    	if(A[l]<A[r]){
    		return A[l];
    	}
    	else if(A[l]>A[r]){
    		if(A[m]>A[l]){
    			return helper(A,m+1,r);
    		}
    		else if(A[m]<A[l]){
    			return helper(A,l,m-1);
    		}
    		else{
    			return Math.min(helper(A,m+1,r),helper(A,l,m-1));
    		}
    	}
    	else{
    		return Math.min(helper(A,m+1,r),helper(A,l,m-1));
    	}
    }

}
