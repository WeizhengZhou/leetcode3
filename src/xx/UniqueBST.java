package xx;

public class UniqueBST {
	public int numTrees(int n) {
		if(n<=0){return 0;}
		int[] nWays=new int[n+1];
		nWays[0]=1;
		for(int i=1;i<=n;i++){
			int ways=0;
			for(int j=1;j<=i;j++){
				ways+=nWays[j-1]*nWays[i-j];
			}
			nWays[i]=ways;
		}
		return nWays[n];
	}
}
