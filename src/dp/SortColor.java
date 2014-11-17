package dp;

public class SortColor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void sortColors(int[] A) {
        if (A==null || A.length==0){
        	return;
        }
        int l=-1;
        int i=0;
        int r=A.length;
        while (i<r){
        	if (A[i]==0){
        		swap(++l,i++,A);
        	}
        	else if(A[i]==1){
        		i++;
        	}
        	else if(A[i]==2){
        		swap(--r,i,A);
        	}
        }
    }
    
    public void swap(int i,int j,int[] A){
    	int temp=A[i];
    	A[i]=A[j];
    	A[j]=temp;
    }

}
