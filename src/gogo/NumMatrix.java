package gogo;

public class NumMatrix {
	int[][] sum;
    public NumMatrix(int[][] matrix) {
    	if (matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) return; 
    	int n=matrix.length;
    	int m=matrix[0].length;
        sum=new int[n][m];
        int pre=0;
        for (int i=0;i<n;i++) {
        	pre+=matrix[i][0];
        	sum[i][0]=pre;
        }
        pre=0;
        for (int j=0;j<m;j++) {
        	pre+=matrix[0][j];
        	sum[0][j]=pre;
        }
        for(int i=1;i<n;i++) {
        	for(int j=1;j<m;j++) {
        		sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+matrix[i][j];
        	}
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if (row2>=sum.length || col2>=sum[0].length) return 0;
        if (row1==0 && col1==0) return sum[row2][col2];
        if (row1==0 && col1!=0) return sum[row2][col2]-sum[row2][col1-1];
        if (row1!=0 && col1==0) return sum[row2][col2]-sum[row1-1][col2];
        return sum[row2][col2]-sum[row2][col1-1]-sum[row1-1][col2]+sum[row1-1][col1-1];
        // 4,3 - 4,0 - 1,3+1,0
        // 1 98 99 98
    }
}
