package gogo;

import java.util.Arrays;
/*
 * [1, 1, 2, 3, 1, 2, 3, 4, 2, 3, 4]
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
 * */
public class CoinChange {
	public static void main(String[] args) {
		CoinChange c=new CoinChange();
		System.out.println(c.coinChange(new int[] {2},3));
	}
	public int coinChange(int[] coins, int amount) {
		if (amount<=0 || coins==null || coins.length==0) return 0;
		int[] ways=new int[amount];
		for(int i=0;i<amount;i++) {
			ways[i]=Integer.MAX_VALUE;
			for(int j=0;j<coins.length;j++) {
				if (i+1==coins[j]) {
					ways[i]=1; break;
				} else {
					if (i-coins[j]>=0 && ways[i-coins[j]]!=Integer.MAX_VALUE) {
						ways[i]=Math.min(ways[i], ways[i-coins[j]]+1);
					}
				}
			}
		}
		System.out.println(Arrays.toString(ways));
		return ways[amount-1]==Integer.MAX_VALUE ? -1 : ways[amount-1];
	}
}
