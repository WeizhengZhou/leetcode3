package gogo;

public class SetZeros {
	public void setZeroes(int[][] matrix) {
        if (matrix ==null || matrix.length==0 || matrix[0]==null || matrix[0].length ==0) return;
        for (int i=1;i<matrix.length;i++) {
        	for (int j=1;j<matrix[0].length;j++) {
        		if (matrix[i][j]==0) {
        			matrix[i][0] = 0;
        			matrix[0][j] = 0;
        		}
        	}
        }
        for (int i=1;i<matrix.length;i++) {
        	for (int j=1;j<matrix[0].length;j++) {
        		if (matrix[i][j]==0) {
        			matrix[i][0] = 0;
        			matrix[0][j] = 0;
        		}
        	}
        }
    }
}
