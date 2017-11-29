package gogo;

public class BestTimeBuySellCooldown {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<2) return 0;
        int max=-prices[0];
        int lastSell=0;
        int lastNS=0;
        for(int i=1;i<prices.length;i++) {
        	int sell=prices[i]+max;
        	int ns=Math.max(lastNS, lastSell);
        	max=Math.max(max, lastNS-prices[i]);
        	lastSell=sell;
        	lastNS=ns;
        }
        return Math.max(lastSell, lastNS);
    }
}
