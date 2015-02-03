package zz;

public class SearchInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{3,5,7,9,10};
		int target = 8;
		SearchInsert solu = new SearchInsert();
		System.out.println(solu.searchInsert(A, target));
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
	//zz consider this code
//	private int helper(int[] A, int l, int r, int target){
//		System.out.println("l = " + l + ", r = "+r);
//		if(l>r){
//			if(r<0) return 0;
//			else if(l>=A.length) return A.length;
//			else if(target <= A[r]) return r;
//			else return r+1;
//		}
//		int m = l + (r-l)/2;
//		if(target == A[m]) return m;
//		else if(target < A[m]) return helper(A,l,m-1,target);
//		else return helper(A,m+1,r,target);
//	}
//	
}
