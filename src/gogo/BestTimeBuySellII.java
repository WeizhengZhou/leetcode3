package gogo;

public class BestTimeBuySellII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length<=1) return 0;
        int sum=0;
        //[7, 1, 5, 3, 6, 4]
        int min = prices[0];
        for (int i=1;i<prices.length;i++) {
        	if( prices[i-1]>prices[i]) {
        		sum+=prices[i-1]-min>0 ? prices[i-1]-min : 0;
        		min=prices[i];
        	}
        }
        if (prices[prices.length-1]>=prices[prices.length-2]) {
        	sum+=prices[prices.length-1]-min>0 ? prices[prices.length-1]-min : 0;
        }
        return sum;
    }
}
