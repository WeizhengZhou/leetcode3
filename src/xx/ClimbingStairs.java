package xx;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if(n<=1) return n;
		int[] nWays=new int[n+1];
		nWays[0]=1;
		nWays[1]=1;
		for(int i=2;i<=n;i++){
			nWays[i]=nWays[i-1]+nWays[i-2];
		}
		return nWays[n];
	}
}
