package dp;

public class UniquePath {
	public static void main(String[] args) {
		UniquePath u=new UniquePath();
		System.out.println(u.UniquePaths(3, 3));

	}

	public int UniquePaths(int m, int n){
		/*
		 * you should check if m <0 & n<0, 
		 * otherwise, you may have this kind of error, "new int[-1][-1]"
		 */
		int[][] matrix=new int[m][n];
		/*
		 * by default, matrix is initialized with zeros  
		 */
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				matrix[i][j]=0;
			}
		}
		
		return helper(0,0,matrix,m,n);
	}
	/*
	 *use "matrix" instead of "ma" for clairty  
	 */	
	public int helper(int x,int y, int[][] ma,int m, int n){
		if (x==(m-1) && y==n-1) return 1;
		if (ma[x][y]>0) return ma[x][y];
		if(x<m-1){
			ma[x][y]+=helper(x+1,y,ma,m,n);
		}
		if(y<n-1){
			ma[x][y]+=helper(x,y+1,ma,m,n);
		}
		return ma[x][y];	
	}
	
}
