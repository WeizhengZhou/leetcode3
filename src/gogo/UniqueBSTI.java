package gogo;

public class UniqueBSTI {
	public int numTrees(int n) {
        if (n<=1) return n;
        int[][] trees = new int[n+1][n+1];
        return helper(1,n, n, trees);
    }
	private int helper(int l, int r, int n, int[][] trees) {
		if (l>=r || l<=0 || r>n) return 1;
		if (trees[l][r]>0) return trees[l][r];
		int sum=0;
		for (int i=l;i<=r;i++){
			sum+=helper(l,i-1,n,trees)*helper(i+1,r,n,trees);
		}
		trees[l][r] = sum;
		return sum;
	}
}
