package gogo;

public class Uniquepaths {
	public int uniquePaths(int m, int n) {
        if (m<=0 || n<=0) return 0;
        if (m==1 || n==1) return 1;
        int[][] ways = new int[m][n];
        ways[m-1][n-1] = 1;
        return findWays(0,0,m,n,ways);
    }
	private int findWays(int x, int y, int m, int n, int[][] ways) {
		if (ways[x][y]>0) return ways[x][y];
		if (x>=m || y>=n) return 0;
		if (x==m-1) {
			ways[x][y] = findWays(x,y+1,m,n,ways);
		} else if (y==n-1) {
			ways[x][y] = findWays(x+1,y,m,n,ways);
		} else {
			ways[x][y] = findWays(x,y+1,m,n,ways) + findWays(x+1,y,m,n,ways);
		}
		return ways[x][y];
	}
}
