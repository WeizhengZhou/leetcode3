package dp;

public class BuySellII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuyNSellStock b=new BuyNSellStock();
		System.out.println(b.maxProfit(new int[]{2,1}));

	}
	
	public int maxProfit(int[] prices){
		if (prices==null||prices.length<2){
			return 0;
		}
		int[] gain=new int[prices.length-1];
		for (int i=0;i<prices.length-1;i++){
			gain[i]=prices[i+1]-prices[i];
		}
		int max=Integer.MIN_VALUE;
		int curM=0;
		for(int j=0; j<gain.length;j++){
			curM=Math.max(gain[j]+curM, gain[j]);
			max=Math.max(max, curM);
		}
		return Math.max(0, max);
	}

}
