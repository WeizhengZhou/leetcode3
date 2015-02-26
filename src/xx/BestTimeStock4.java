package xx;

import java.util.Arrays;

public class BestTimeStock4 {
	public int maxProfit(int k, int[] prices){
		if(k<0 || prices == null || prices.length < 2) return 0;
		int len = prices.length;
		int[][] dp = new int[k+1][len];//dp[i][j] is max profit 
									   //can make using at most i transaction
								       //within sub-array prices[0 to i];
		//dp[0][...] = 0, since zero transaction can make zero profit
		//dp[...][0], since only one element sub-array can make zero profit
		//fill 2-D dp array from top-down, left-right 
							
		for(int i=1;i<=k;i++){
			int tempMax = dp[i-1][0] - prices[0];
			for(int j=1;j<len;j++){
				System.out.println("i = " + i + ", j = " + j + ", tempMax = " + tempMax);
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				tempMax = Math.max(tempMax,dp[i-1][j] - prices[j]);
				dp[i][j] = prices[j] + tempMax;			
			}
		}
		for(int i=0;i<=k;i++){
			for(int j=0;j<len;j++){
				System.out.print(dp[i][j] + ", ");
			}
			System.out.println();
		}
		return dp[k][len-1];
	}
	public static void main(String[] args){
		int[] A = new int[]{3,2,6,5,0,3};
		int k =2;
		System.out.println(Arrays.toString(A));
		System.out.println();
		BestTimeStock4 solu = new BestTimeStock4();
		System.out.println(solu.maxProfit(k, A));
	}
}
