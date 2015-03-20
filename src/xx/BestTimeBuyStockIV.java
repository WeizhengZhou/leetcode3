package xx;

public class BestTimeBuyStockIV {
	public int maxProfit(int k, int[] prices) {
        if(k<=0 || prices==null || prices.length<=1)return 0;
        if(k>=prices.length/2){
            int maxProfit=0;
            for(int i=1;i<prices.length;i++){
                int cur=prices[i]-prices[i-1];
                maxProfit+=cur>0?cur:0;
            }
            return maxProfit;
        }
        int[][] maxP=new int[k+1][prices.length];
        int max=0;
        for(int kk=1;kk<=k;kk++){
            int tempMax=-prices[0];
            for(int i=1;i<prices.length;i++){
                maxP[kk][i]=Math.max(maxP[kk][i-1],prices[i]+tempMax);
                tempMax=Math.max(tempMax,maxP[kk-1][i]-prices[i]);
                max=Math.max(max,maxP[kk][i]);
            }
        }
        return max;
    }
}
