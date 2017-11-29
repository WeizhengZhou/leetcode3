package gogo;

public class BestTimeBuySell {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<=1) return 0;
        int max=0;
        int min=prices[0];
        for (int i=1;i<prices.length;i++) {
        	max=Math.max(max, prices[i]-min);
        	if (prices[i]<min) {
        		min=prices[i];
        	}	
        }
        return max;
    }
}
