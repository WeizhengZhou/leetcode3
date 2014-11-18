package dp;

public class RemoveDupII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removeDuplicates(int[] A) {
        if (A==null||A.length==0){
        	return 0;
        }
        int len=-1;
        int i=0;
        int last=A[0];
        int count=0;
        while(i<A.length){
        	if(A[i]!=last){
        		last=A[i];
        		A[++len]=last;
        		count=0;
        	}
        	else{
        		if(count<2){
        			A[++len]=last;
        		}
        	}
        	count++;
        	i++;
        }
        return len+1;
    }

}
