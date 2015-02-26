package xx;

public class BestTimeBuyStock {
	public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1){return 0;}
        int curMax=0;
        int maxProfit=0;
        for(int i=0;i<prices.length-1;i++){
            int diff=prices[i+1]-prices[i];
            curMax+=diff;
            curMax=Math.max(0,curMax);
            maxProfit=Math.max(maxProfit,curMax);
        }
        return maxProfit;
    }
}
