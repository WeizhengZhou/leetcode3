package zz;

public class RemoveDuplicateA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removeDuplicates(int[] A) {
		if(A==null || A.length==0){
			return 0;
		}
		int past=A[0];
		int newLen=0;
		for(int i=1;i<A.length;i++){
			if(A[i]!=past){
				newLen++;
				A[newLen]=A[i];
				past=A[i];
			}
		}
		return newLen+1;
	}

}
