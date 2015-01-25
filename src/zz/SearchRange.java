package zz;

public class SearchRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] searchRange(int[] A, int target) {
		if(A==null || A.length==0){
			return new int[]{-1,-1};
		}
		int start=findStart(0,A.length-1, A,target);
		int end=0;
		if(start!=-1){
			end=findEnd(0,A.length-1,A,target);
			return new int[]{start,end};
		}
		else{
			return new int[]{-1,-1};
		}
	}
	
	public int findStart(int l, int r, int[] A, int target){
		if(l+1==r){
			if(A[l]==target){
				return l;
			}
			if(A[l]<target){
				return A[r]==target?r:-1;
			}
			if(A[l]>target){
				return -1;
			}
		}
		if(l==r){
			return A[l]==target?l:-1;
		}
		int m=l+(r-l)/2;
		if(A[m]==target && A[m-1]<target){
			return m;
		}
		if(A[m]<target){
			return findStart(m+1,r,A,target);
		}
		else{
			return findStart(l,m-1,A,target);
		}
	}

	public int findEnd(int l, int r, int[] A, int target){
		if(l+1==r){
			if(A[r]==target){
				return r;
			}
			if(A[r]>target){
				return A[l]==target?l:-1;
			}
			if(A[r]<target){
				return -1;
			}
		}
		if(l==r){
			return A[l]==target?l:-1;
		}
		int m=l+(r-l)/2;
		if(A[m]==target && A[m+1]>target){
			return m;
		}
		if(A[m]>target){
			return findEnd(l,m-1,A,target);
		}
		else{
			return findEnd(m+1,r,A,target);
		}
	}
}
