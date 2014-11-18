package dp;

public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int firstMissingPositive(int[] A) {
    	if (A==null||A.length==0){
    		return 1;
    	}
        int i=0;
        while(i<A.length){
        	if(A[i]==i+1){
        		i++;
        	}
        	else{
        		if (A[i]>0 && A[i]<=A.length && A[A[i]-1]!=A[i]){
        			int temp=A[A[i]-1];
        			A[A[i]-1]=A[i];
        			A[i]=temp;
        		}
        		else{
        			i++;
        		}
        	}
        }
        for (int j=0; j<A.length;j++){
        	if (A[j]!=j+1){
        		return j+1;
        	}
        }
        return A.length+1;
    }

}
