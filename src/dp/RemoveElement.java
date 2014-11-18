package dp;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int removeElement(int[] A, int elem) {
        if (A==null||A.length==0){
        	return 0;
        }
        int len=-1;
        for (int i=0;i<A.length;i++){
        	if(A[i]!=elem){
        		A[++len]=A[i];
        	}
        }
        return len+1;
    }

}
