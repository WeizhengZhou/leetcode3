package dp;

public class MergeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void merge(int A[], int m, int B[], int n) {
        int len=m+n-1;
        //int s=Math.min(m, n);
        for(;len>0;len--){
        	if(m>0 && n>0){
	        	if(A[m-1]<B[n-1]){
	        		A[len]=B[n-1];
	        		n--;
	        	}
	        	else{
	        		A[len]=A[m-1];
	        		m--;
	        	}
        	}
        	else{
        		break;
        	}
        }
        if(n>0){
        	for(;n>0;n--){
        		A[len]=B[n-1];
        		len--;
        	}
        }
    }

}
