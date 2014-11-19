package dp;

public class BestTimeBuySellII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
        	return 0;
        }
        int[] g=new int[prices.length-1];
        int m=0;
        for(int i=0;i<prices.length-1;i++){
        	g[i]=prices[i+1]-prices[i];
        	if(g[i]>0){
        		m+=g[i];
        	}
        }
        return m;
    }

}
