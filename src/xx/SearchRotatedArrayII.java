package xx;

public class SearchRotatedArrayII {
	public boolean search(int[] A, int target) {
		if(A==null || A.length==0){return false;}
		return bsHelper(0,A.length-1,A,target);
	}

	private boolean bsHelper(int l, int r,int[] A, int target){
		if(l>r){return false;}
		if(l==r){return A[l]==target;}
		int m=l+(r-l)/2;
		if(A[m]==target){
			return true;
		}
		else if(A[m]>A[l]){
			if(target>=A[l]&&target<A[m]){return bsHelper(l,m-1,A,target);}
			else{ return bsHelper(m+1,r,A,target); }	
		}
		else if(A[m]<A[l]){
			if(target<=A[r] && target>A[m]){ return bsHelper(m+1,r,A,target); }
			else{ return bsHelper(l,m-1,A,target); }
		}
		else{
			if(bsHelper(l,m-1,A,target)){return true;}
			else{return bsHelper(m+1,r,A,target);}
		}
	}
}
