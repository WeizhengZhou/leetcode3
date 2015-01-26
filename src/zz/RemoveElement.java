package zz;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int removeElement(int[] A, int elem){
		if(A==null || A.length==0){
			return 0;
		}
		int newLen=-1;
		for(int i=0;i<A.length;i++){
			if(A[i]!=elem){
				newLen++;
				A[newLen]=A[i];
			}
		}
		return newLen+1;
	}
	
}
