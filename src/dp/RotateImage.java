package dp;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void rotate(int[][] matrix) {
    	if (matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0){
    		return;
    	}
    	int n=matrix.length;
    	for(int d=0;d<n/2;d++){
    		for(int i=d;i<n-1-d;i++){
    			int temp=matrix[d][i];
    			matrix[d][i]=matrix[n-1-i][d];
    			matrix[n-1-i][d]=matrix[n-1-d][n-1-i];
    			matrix[n-1-d][n-1-i]=matrix[i][n-1-d];
    			matrix[i][n-1-d]=temp;   			    			
    		}
    	}
    	return;
    }

}
