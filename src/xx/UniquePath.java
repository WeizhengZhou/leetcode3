package xx;

public class UniquePath {
	public int uniquePaths(int m, int n) {
		if(m==0 || n==0)return 0;
		int[][] nWays=new int[m][n];
		for(int i=0;i<m;i++){nWays[i][0]=1;}
		for(int j=0;j<n;j++){nWays[0][j]=1;}
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				nWays[i][j]=nWays[i-1][j]+nWays[i][j-1];
			}
		}
		return nWays[m-1][n-1];
	}
}
