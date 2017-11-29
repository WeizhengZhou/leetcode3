package gogo;

public class MaxSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] max=new int[n][m];
        int r=0;
        for (int i=0;i<n;i++) {
        	max[i][0] = matrix[i][0]=='1'?1:0;
        	r=Math.max(r, max[i][0]);
        }
        for (int i=0;i<m;i++) {
        	max[0][i] = matrix[0][i]=='1'?1:0;
        	r=Math.max(r, max[0][i]);
        }
        for(int i=1;i<n;i++) {
        	for(int j=1;j<m;j++) {
        		if (matrix[i][j]=='1') {
        			max[i][j]=Math.min(Math.min(max[i-1][j],max[i][j-1]), max[i-1][j-1]) + 1;
        		}
        		
        		r=Math.max(r, max[i][j]);
        	}
        }
        return r*r;
    }
}
