package dp;

public class MinPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minPathSum(int [][]grid){
		int nRows=grid.length;
		int nCols=grid[0].length;
		int[][] A=new int[nRows][nCols];
		A[nRows-1][nCols-1]=grid[nRows-1][nCols-1];
		for(int i=nRows-2;i>=0;i--){
			A[i][nCols-1]=grid[i][nCols-1]+A[i+1][nCols-1];
		}
		for(int j=nCols-2;j>=0;j--){
			A[nRows-1][j]=grid[nRows-1][j]+A[nRows-1][j+1];
		}
		for(int i=nRows-2; i>=0; i--){
			for(int j=nCols-2;j>=0;j--){
				A[i][j]=Math.min(A[i+1][j], A[i][j+1])+grid[i][j];
			}
		}
		return A[0][0];
	}

}
