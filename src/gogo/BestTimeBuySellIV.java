package gogo;

public class BestTimeBuySellIV {
	// not pass OJ
    public int maxProfit(int k, int[] prices) {
        if (prices==null || prices.length<2||k==0) return 0;
        int len = prices.length;
        int[][] minA = new int[len][len];
        int[][] maxA = new int[len][len];
        for (int i=0; i<len;i++) {
        	int min = prices[i];
            int max=prices[i];
        	for(int j=i;j<len;j++) {
        		minA[i][j] = Math.min(min, prices[j]);
            	maxA[i][j] = Math.max(max, prices[j]);
        	}        	
        }
        int[] gain=new int[len];
        for(int i=0;i<len;i++) {
        	gain[i]=maxA[0][i]-minA[0][i];
        }
        if (k==1) return gain[len-1];
        for (int l=2;l<=k;l++) {
        	int[] next = new int[len];
        	for(int i=1;i<len;i++) {
        		int max=0;
        		for (int j=1;j<i;j++) {
        			max=Math.max(max, gain[j] + maxA[j][i]-minA[j][i]);
        		}
        		next[i] = max;
        	}
        	gain=next;
        }
        return gain[len-1];
    }
}
