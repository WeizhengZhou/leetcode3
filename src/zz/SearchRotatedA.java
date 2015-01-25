package zz;

public class SearchRotatedA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int search(int[] A, int target) {
		 if(A==null || A.length==0){
			 return -1;
		 }
		 return bsHelper(0,A.length-1,A,target);
	 }
	 
	 public int bsHelper(int l,int r, int[] A,int target){
		 if(l>r){
			 return -1;
		 }
		 if(l==r){
			 return A[l]==target?l:-1;
		 }
		 int m=l+(r-l)/2;
		 if(A[m]==target){
			 return m;
		 }
		 if(A[m]>A[r]){
			 if(A[m]>target && target>=A[l]){
				 return bsHelper(m+1,r,A,target);
			 }
			 else{
				 return bsHelper(l,m-1,A,target);
			 }
		 }
		 else{
			 if(A[m]<target && target<=A[r]){
				 return bsHelper(m+1,r,A,target);
			 }
			 else{
				 return bsHelper(l,m-1,A,target);
			 }
		 }
	 }

}
