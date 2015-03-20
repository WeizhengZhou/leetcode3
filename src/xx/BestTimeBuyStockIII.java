package xx;

public class BestTimeBuyStockIII {
	public int maxProfit(int[] prices){
		if(prices==null || prices.length<=1){return 0;}
		int len=prices.length;
		int[] gain=new int[len-1];
		int[] left=new int[len];
		int[] right=new int[len];
		int curLeft=0;
		int maxLeft=0;
		for(int i=0;i<len-1;i++){
			gain[i]=prices[i+1]-prices[i];
			left[i]=maxLeft;
			curLeft+=gain[i];
			curLeft=Math.max(0,curLeft);
			maxLeft=Math.max(maxLeft,curLeft);
		}
		left[len-1]=maxLeft;
		int curRight=0;
		int maxRight=0;
		int profit=0;
		for(int i=len-1;i>0;i--){
			right[i]=maxRight;
			curRight+=gain[i-1];
			curRight=Math.max(curRight,0);
			maxRight=Math.max(maxRight,curRight);
			profit=Math.max(profit,left[i]+right[i]);
		}
		right[0]=maxRight;
		profit=Math.max(profit,left[0]+right[0]);
		return profit;
	}
}
