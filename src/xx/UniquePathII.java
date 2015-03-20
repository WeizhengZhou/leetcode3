package xx;

public class UniquePathII {
	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0]==null || obstacleGrid[0].length==0||obstacleGrid[0][0]==1)return 0;
	        int n=obstacleGrid.length;
	        int m=obstacleGrid[0].length;
	        int[][] nWays=new int[n][m];
	        nWays[0][0]=1;
	        for(int i=1;i<n;i++){
	            nWays[i][0]=obstacleGrid[i][0]==1?0:nWays[i-1][0];
	        }
	        for(int j=1;j<m;j++){
	            nWays[0][j]=obstacleGrid[0][j]==1?0:nWays[0][j-1];
	        }
	        for(int i=1;i<n;i++){
	            for(int j=1;j<m;j++){
	                nWays[i][j]=obstacleGrid[i][j]==1?0:nWays[i-1][j]+nWays[i][j-1];
	            }
	        }
	        return nWays[n-1][m-1];
	    }
}
