package xx;

public class SerchRotatedArray {
	public int search(int[] A, int target) {
        if(A==null||A.length==0)return -1;
        return bsHelper(0,A.length-1,A,target);
	 }
	 private int bsHelper(int l,int r,int[] A,int target){
	     if(l>r)return -1;
	     if(l==r){return A[l]==target?l:-1;}
	     int m=l+(r-l)/2;
	     if(A[m]==target){return m;}
	     else if(A[l]<=A[m]){
	         if(target>=A[l] && target<A[m]){return bsHelper(l,m-1,A,target);}
	         else{return bsHelper(m+1,r,A,target);}
	     }
	     else{
	         if(target>A[m] && target<=A[r]){
	             return bsHelper(m+1,r,A,target);
	         }
	         else{
	             return bsHelper(l,m-1,A,target);
	         }
	     }
	 }
}
