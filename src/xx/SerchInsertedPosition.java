package xx;

public class SerchInsertedPosition {
	public int searchInsert(int[] A, int target) {
	    if(A==null || A.length==0){return 0;}
	    return bsHelper(0,A.length-1,A,target);
    }
    private int bsHelper(int l, int r,int[] A, int target){
        if(l==r){
            if(A[l]<target){return l+1;}
            else{return l;}
        }
        else if(l+1==r){
            if(A[l]>=target){return l;}
            else if(A[r]>=target){return r;}
            else{return r+1;}
        }
        int m=l+(r-l)/2;
        if(A[m]==target || A[m-1]<target && A[m]>target){
            return m;
        }
        else if(A[m]>target){
            return bsHelper(l,m-1,A,target);
        }
        else{
            return bsHelper(m+1,r,A,target);
        }
    }
}
