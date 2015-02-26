package xx;

public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] A){
		if(A==null || A.length==0){return 0;}
		int count=0;
		int len=-1;
		int last=A[0]+1;
		for(int i=0;i<A.length;i++){
			if(A[i]!=last){
				A[++len]=A[i];
				count=1;
				last=A[i];
			}
			else{
				if(count<2){
					A[++len]=A[i];
					count++;
				}
			}
		}
		return len+1;
	}
}
