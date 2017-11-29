package additional;

import java.util.HashMap;
import java.util.Map;

public class GuessNumberHigherLower {
	public int getMoneyAmount(int n) {
		int[] dp=new int[n+1];
        if (n<=1) return 0;
        if (n<=3) return n-1;
		dp[2]=1;
		dp[3]=2;
		String s=new String(new char[] {}, 0,1);
		StringBuilder sb=new StringBuilder(s);
		
		for (int i=4;i<=n;i++) {
			int min=Integer.MAX_VALUE;
			for(int j=1;j<=i/2+1;j++) {
				min=Math.min(min, j+Math.max(j+dp[i-j], dp[j-1]));
			}
            dp[i]=min;
		}
		Map<int[],Integer> map=new HashMap<> ();
		return dp[n];
	}
	
	private boolean helper(int last, int cur, int[] stones, Map<Integer,Integer> map, Map<String, Boolean> cache) {
        if (cur==stones.length-1) return true;
        String key=String.valueOf(last)+":"+String.valueOf(cur);
        if (cache.containsKey(key)) return cache.get(key);
        int val=stones[cur];
        boolean res=false;
        if (last-1>0 && map.containsKey(val+last-1)) {
            if (helper(last-1,map.get(val+last-1),stones,map,cache)) res= true;
        }
        if (last>0 && map.containsKey(val+last)) {
            if (helper(last,map.get(val+last),stones,map,cache)) res= true;
        } 
        if (map.containsKey(val+last+1)) {
            if (helper(last+1,map.get(val+last+1),stones,map,cache)) res= true;
        } 
        cache.put(key, res);
        return res;
    }
	
}
