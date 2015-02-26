package xx;

public class MinPathSUm {
	 public int minPathSum(int[][] grid) {
	        if(grid==null || grid.length==0 || grid[0].length==0){return 0;}
	        int n=grid.length;
	        int m=grid[0].length;
	        int[][] minSum=new int[n][m];
	        minSum[0][0]=grid[0][0];
	        for(int i=1;i<n;i++){minSum[i][0]=minSum[i-1][0]+grid[i][0];}
	        for(int j=1;j<m;j++){minSum[0][j]=minSum[0][j-1]+grid[0][j];}
	        for(int i=1;i<n;i++){
	            for(int j=1;j<m;j++){
	                minSum[i][j]=Math.min(minSum[i-1][j],minSum[i][j-1])+grid[i][j];
	            }
	        }
	        return minSum[n-1][m-1];
	    }
}
