package xx;

public class RemoveDuplicatesSortedArray {
	public int removeDuplicates(int[] A) {
        if(A==null || A.length==0){
			return 0;
		}
		int last=A[0];
		int index=0;
		for(int i=1;i<A.length;i++){
		    if(A[i]!=last){
		        A[++index]=A[i];
		        last=A[i];
		    }
		}
		return index+1;
    }
}
