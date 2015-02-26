package xx;

public class MergeSortedArray {
	  public void merge(int A[], int m, int B[], int n) {
	       if(A==null || A.length==0 || B==null){return;}
	       int len=m+n-1;
	       n--;
	       m--;
	       while(n>=0){
	           int cur=B[n];
	           if(m>=0 && A[m]>cur){
	               cur=A[m--];
	           }
	           else{n--;}
	           A[len--]=cur;
	       }
	    }
}
