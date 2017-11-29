package gogo;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] ways = new int[m][n];
        for (int i=m-1;i>=0;i--) {
        	for (int j=n-1;j>=0;j--) {
        		if (obstacleGrid[i][j]==1) {
        			ways[i][j]=0;
        		} else if (i==m-1 && j==n-1) {
        			ways[i][j] = 1;
        		} else if (i==m-1) {
        			ways[i][j] = ways[i][j+1];
        		} else if (j == n-1) {
        			ways[i][j] = ways[i+1][j];
        		} else {
        			ways[i][j] = ways[i+1][j] + ways[i][j+1];
        		}
        	}
        }
        return ways[0][0];
    }
}
