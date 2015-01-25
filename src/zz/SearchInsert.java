package zz;

public class SearchInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int searchInsert(int[] A, int target) {
		if(A==null || A.length==0){
			return 0;
		}
		return BShelper(0,A.length-1,target,A);
	}
	
	public int BShelper(int l, int r, int target, int[] A){
		if(l==r){
			if(A[l]>=target){
				return l;
			}
			else{
				return l+1;
			}
		}
		if(l+1==r){
			if(A[l]>=target){
				return l;
			}
			else if (A[r]>=target){
				return r;
			}
			else{
				return r+1;
			}
		}
		int m=l+(r-l)/2;
		if(A[m]==target || A[m-1]<target && A[m]>target){
			return m;
		}
		if(A[m]<target){
			return BShelper(m+1,r,target,A);
		}
		else{
			return BShelper(l,m-1,target,A);
		}
	}
}
