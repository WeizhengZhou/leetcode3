package gogo;

public class BestTimeBuySellIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length<=1) return 0;
        int[] max=new int[prices.length];
        //[7, 1, 5, 3, 6, 4]
        int min = prices[0];
        int leftMax = 0;
        int maxSum = 0;
        for (int i=1;i<prices.length;i++) {
        	int cur = prices[i]-min;
        	if (cur>leftMax) {
        		leftMax=cur;
        	}
        	if (prices[i]<min) {
        		min = prices[i];
        	}
        	max[i]=leftMax;
        }
        int rightMax=0;
        int rightH = prices[prices.length-1];
        for (int i=prices.length-2;i>=0;i--) {
        	int cur = rightH-prices[i];
        	if (cur>rightMax) {
        		rightMax=cur;
        	}
        	if (prices[i]>rightH) {
        		rightH = prices[i];
        	}
        	maxSum=Math.max(maxSum, max[i]+rightMax);
        }
        return maxSum;
    }
}
