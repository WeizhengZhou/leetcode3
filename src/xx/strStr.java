package xx;

public class strStr {
	  public int removeElement(int[] A, int elem) {
	        int index=-1;
	        for(int i=0;i<A.length;i++){
	            if(A[i]!=elem){
	                A[++index]=A[i];
	            }
	        }
	        return index+1;
	    }
}
