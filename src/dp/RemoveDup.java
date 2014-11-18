package dp;

public class RemoveDup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int removeDuplicates(int[] A) {
        if (A==null||A.length==0){
        	return 0;
        }
        int len=0;
        int i=1;
        int last=A[0];
        while(i<A.length){
        	if(A[i]!=last){
        		last=A[i];
        		A[++len]=last;
        	}
        	i++;
        }
        return len+1;
    }

}
