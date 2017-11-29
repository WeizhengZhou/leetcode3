package gogo;

public class PerfectSquares {
    public int numSquares(int n) {
        if (n<0) {
        	return 0;
        }
        if (n<=1) return 1;
        int[] ways=new int[n+1];
        ways[0] = 1;
        ways[1] = 1;
        for(int i=2;i<=n;i++) {
        	int sqrt = (int)Math.sqrt(i);
        	if (sqrt*sqrt == i) {
        		ways[i]=1;
        	} else {
            	int min=i;
            	for (int j=1;j<=i/2;j++) {
            		int cur=ways[j]+ways[i-j];
            		min=Math.min(min, cur);
            	}
            	ways[i]=min;
        	}
        }
        return ways[n];
    }
}
