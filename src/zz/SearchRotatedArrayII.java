//zz reviewed
package zz;

public class SearchRotatedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean search(int[] A, int target) {
		if(A==null|| A.length==0){
			return false;
		}
		return bs(0,A.length-1,A,target);
	}
	
	public boolean bs(int l, int r, int[] A, int target){
		if(l>r){
			return false;
		}
		if(l==r){
			return A[l]==target;
		}
		int m=l+(r-l)/2;
		if(A[m]==target){
			return true;
		}
		if(A[l]<A[m]){
			if(target>A[m]){
				return bs(m+1,r,A,target);
			}
			else{
				return bs(m+1,r,A,target)||bs(l,m-1,A,target);
			}
		}
		else if(A[r]>A[m]){
			if(target<A[m]){
				return bs(l,m-1,A,target);
			}
			else{
				return bs(l,m-1,A,target)||bs(m+1,r,A,target);
			}
		}
		else{
			return bs(l,m-1,A,target)||bs(m+1,r,A,target);
		}
	}

}
