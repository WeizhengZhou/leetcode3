package dp;

public class UniquePathWithO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePathWithO u=new UniquePathWithO();
		int s=u.uniquePathWO(new int[][]{{0,0},{0,0}});
System.out.println(s);
	}
	
	public int uniquePathWO(int[][] obstacleGrid){
		int m=obstacleGrid.length;
		int n=obstacleGrid[0].length;
		int[][] ma=new int[m][n];
		for(int i=0; i<m; i++){
			for(int j=0;j<n;j++){
				ma[i][j]=0;
			}
		}
		ma[m-1][n-1]=obstacleGrid[m-1][n-1]==0?1:0;
		for(int i=m-2;i>=0;i--){
			if(obstacleGrid[i][n-1]==1){
				ma[i][n-1]=0;
			}
			else ma[i][n-1]=ma[i+1][n-1];
		}
		for(int i=n-2;i>=0;i--){
			if(obstacleGrid[m-1][i]==1){
				ma[m-1][i]=0;
			}
			else ma[m-1][i]=ma[m-1][i+1];
		}
		for(int i=m-2;i>=0;i--){
			for(int j=n-2;j>=0;j--){
				if (obstacleGrid[i][j]==1) {
					ma[i][j]=0;
				}
				else{
					ma[i][j]=ma[i+1][j]+ma[i][j+1];
				}
			}
		}
		return ma[0][0];
	}
	
	public int helper(int x,int y, int[][] ma,int m, int n,int[][] o){
		if (x==m-1 && y==n-1){
			return o[m-1][n-1]==0?1:0;
		}
		if (ma[x][y]>0){
			return ma[x][y];
		}
		if (x<m-1&&o[x+1][y]==0){
			ma[x][y]+=helper(x+1,y,ma,m,n,o);
		}
		if (y<n-1&&o[x][y+1]==0){
			ma[x][y]+=helper(x,y+1,ma,m,n,o);
		}
		return ma[x][y];
	}

}
