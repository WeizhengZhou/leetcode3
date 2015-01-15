package zz;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void merge(int A[], int m, int B[], int n) {
		if(A==null || B==null || A.length==0 || B.length==0 || n==0){
			return;
		}
		int len=m+n-1;
		for(;len>=0;len--){
			//int d=0;
			if(m>=0 && n>=0){
				A[len]=Math.max(A[m-1], B[n-1]);
				if(A[len]==A[m-1]){
					m--;
				}
				else{
					n--;
				}
			}
			else{
				break;
			}
		}
		int[] remain=m==0?B:A;
		int l=m==0?n:m;
		for(;l>0;l--){
			//len--;
			A[len--]=remain[l-1];
		}
	}

}
