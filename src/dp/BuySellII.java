package dp;

import java.util.Arrays;

public class BuySellII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuySellII b=new BuySellII();
		System.out.println(b.maxProfit(new int[]{2,1,2,0,1}));

	}
	
	public int maxProfit(int[] prices){
		if (prices==null||prices.length<2){
			return 0;
		}
		int[] gain=new int[prices.length-1];
		int[] maxL=new int[prices.length];
		int[] maxR=new int[prices.length];
		for (int i=0;i<prices.length-1;i++){
			gain[i]=prices[i+1]-prices[i];
		}
		int max=Integer.MIN_VALUE;
		int curM=0;
		maxL[0]=0;
		for(int j=0; j<gain.length;j++){
			curM=Math.max(0, Math.max(gain[j]+curM, gain[j]));
			max=Math.max(max, curM);
			maxL[j+1]=max;			
		}
		maxR[maxR.length-1]=0;
		int rCurM=0;
		max=Integer.MIN_VALUE;
		int maxT=Integer.MIN_VALUE;
		for(int k=gain.length-1;k>=0;k--){
			rCurM=Math.max(0, Math.max(gain[k]+rCurM, gain[k]));
			max=Math.max(rCurM, max);
			maxR[k]=max;
			maxT=Math.max(maxT, maxL[k]+maxR[k]);
		}
		maxT=Math.max(maxT, maxL[maxL.length-1]);
		System.out.println("p: "+Arrays.toString(prices));
		System.out.println("g: "+Arrays.toString(gain));
		System.out.println("l: "+Arrays.toString(maxL));
		System.out.println("R: "+Arrays.toString(maxR));
		return Math.max(0, maxT);
	}

}
