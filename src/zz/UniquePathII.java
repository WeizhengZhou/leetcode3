package zz;

public class UniquePathII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		 if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0 ||obstacleGrid[0][0]==1){
			 return 0;
		 }
		 int nRows=obstacleGrid.length;
		 int nCols=obstacleGrid[0].length;
		 int[][] ways=new int[nRows][nCols];
		 ways[0][0]=1;
		 for(int i=1;i<nRows;i++){
			 ways[i][0]=obstacleGrid[i][0]==1?0:ways[i-1][0];
		 }
		 for(int j=1;j<nCols;j++){
			 ways[0][j]=obstacleGrid[0][j]==1?0:ways[0][j-1];
		 }
		 for(int i=1;i<nRows;i++){
			 for(int j=1;j<nCols;j++){
				 ways[i][j]=obstacleGrid[i][j]==1?0:(ways[i-1][j]+ways[i][j-1]);
			 }
		 }
		 return ways[nRows-1][nCols-1];
	 }

}
