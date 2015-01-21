package zz;

public class MinPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
        	return 0;
        }
        int[][] minSum=new int[grid.length][grid[0].length];
        minSum[0][0]=grid[0][0];
        for(int i=1;i<grid[0].length;i++){
        	minSum[0][i]=minSum[0][i-1]+grid[0][i];
        }
        for(int i=1;i<grid.length;i++){
        	minSum[i][0]=minSum[i-1][0]+grid[i][0];
        }
        for(int i=1;i<grid.length;i++){
        	for(int j=1;j<grid[0].length;j++){
        		minSum[i][j]=Math.min(minSum[i-1][j], minSum[i][j-1])+grid[i][j];
        	}
        }
        return minSum[grid.length-1][grid[0].length-1];
    }

}
