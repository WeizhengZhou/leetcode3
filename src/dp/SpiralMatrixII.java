package dp;

public class SpiralMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[][] generateMatrix(int n) {
        if (n==0){
        	return new int[0][0];
        }
        int[][] matrix=new int[n][n];
        int j=1;
    	for (int d=0; d<n/2;d++){
    		for (int i=d;i<n-1-d;i++){
    			matrix[d][i]=j++;
    		}
    		for (int i=d;i<n-1-d;i++){
    			matrix[i][n-1-d]=j++;
    		}
    		for (int i=d;i<n-1-d;i++){
    			matrix[n-1-d][n-1-i]=j++;
    		}
    		for (int i=d;i<n-1-d;i++){
    			matrix[n-1-i][d]=j++;
    		}
    	}
    	if (n%2==1){
    		matrix[n/2][n/2]=n*n;
    	}
    	return matrix;
    }

}
