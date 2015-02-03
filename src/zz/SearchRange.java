//zz reviewed
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
	
	//zz for binary search in general
	//zz l+1==r, is not a sepecial case, but can be handled in later cases
	//zz in addition, l>r is a serious speical case
	//zz see wiki's binary search algorithm
	
	int binary_search(int A[], int key, int imin, int imax){		
	// test if array is empty
		if (imax < imin)
		// set is empty, so return value showing not found
			return -1;
		else{// calculate midpoint to cut set in half
			int imid = (imin+imax)/2;
			// three-way comparison
			if (A[imid] > key)
			// key is in lower subset
				return binary_search(A, key, imin, imid - 1);
			else if (A[imid] < key)
			// key is in upper subset
				return binary_search(A, key, imid + 1, imax);
			else
				// key has been found
				return imid;
		}
	}
	//zz and my code is based on the binary search
	//zz your findStart and findEnd is merge in one method

	private int helper(int[] A, int l, int r, int target, boolean isStart){
		if(A == null) return -1;
		if(l<0 || r>=A.length || l>r) return -1;
		int m = l + (r-l)/2;
		if(A[m] == target){
			if(isStart == true){
				if(m ==0 || A[m-1] < target)//m is the start of target
					return m; 
				else
					return helper(A,l,m-1,target,isStart);//m is not the start
			}
			else{
				if(m == A.length-1 || A[m+1] > target)//m is the end of target
					return m;
				else
					return helper(A,m+1,r,target,isStart);//m is not the end of target
			}  
		}
		else if(target < A[m]){//target is smaller than A[m], search on left half
			return helper(A,l,m-1,target,isStart);
		}
		else//search on right half
			return helper(A,m+1,r,target,isStart);
	}


	public int findStart(int l, int r, int[] A, int target){//zz private method
		//zz check l>r, instead of l+1==r

		
		if(l+1==r){//zz check l==r first
			if(A[l]==target){
				return l;
			}
			if(A[l]<target){
				return A[r]==target?r:-1;
			}
			if(A[l]>target){
				return -1;
			}
			//zz if(target < A[l]) return -1;
			//   else if(target == A[l]) return l;
			//   else if(target == A[r]) return r;
			//   else return -1;
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
