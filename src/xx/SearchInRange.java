package xx;

public class SearchInRange {
	public int[] searchRange(int[] A, int target) {
		int[] res=new int[]{-1,-1};
		if(A==null || A.length==0){return res;}
		int start=bsHelper(0,A.length-1,A,target,true);
		if(start==-1){return res;}
		int end=bsHelper(0,A.length-1,A,target,false);
		return new int[]{start,end};
	}

	private int bsHelper(int l, int r, int[] A, int target, boolean isStart){
		if(l>r){return -1;}
		if(l==r){ return A[l]==target?l:-1;}
		int m=l+(r-l)/2;
		if(A[m]==target){
		if(isStart){
		if(m==0 || A[m-1]<A[m]){return m;}
		else{ return bsHelper(l,m-1,A,target,isStart); }
	}
	else{
		if(m==A.length-1 || A[m+1]>A[m]){return m;}
		else{ return bsHelper(m+1,r,A,target,isStart); }
	}
	}
	else if(A[m]<target){
		return bsHelper(m+1,r,A,target,isStart);
	}
	else{
		return bsHelper(l,m-1,A,target,isStart);
	}
	}
}
