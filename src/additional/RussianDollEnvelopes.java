package additional;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
	public static void main(String[] args) {
		RussianDollEnvelopes r=new RussianDollEnvelopes();
		int[][] e=new int[][] {{5,4},{6,4},{6,7},{2,3}};
		System.out.print(r.maxEnvelopes(e));
	}
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes==null || envelopes.length==0) return 0;
		int[] dp=new int[envelopes.length];
		dp[0]=1;
		int max=1;
		Arrays.sort(envelopes, new Comparator<int[]> () {
		
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0]!=o2[0]) return o1[0]-o2[0];
				return o1[1]-o2[1];
			}});
		for(int i=1;i<envelopes.length;i++) {
			int[] cur=envelopes[i];
			dp[i]=1;
			for(int j=0;j<i;j++) {
				int[] pre=envelopes[j];
		        
				if (cur[0]>pre[0] && cur[1]>pre[1]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
		        
			}
		    max=Math.max(max,dp[i]);
		}
		return max;
    }
}
