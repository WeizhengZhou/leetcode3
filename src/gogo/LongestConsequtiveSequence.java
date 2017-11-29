package gogo;

import java.util.HashMap;
import java.util.Map;

public class LongestConsequtiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums==null) return 0;
        if (nums.length<=1) return nums.length;
        int max = 1;
        Map<Integer, int[]> map = new HashMap<> ();
        for (int i=0;i<nums.length;i++) {
        	int cur = nums[i];
        	if (map.containsKey(cur)) continue;
        	int lower = 1;
        	int upper = 1;
        	if (map.containsKey(cur+1)) {
        		int upLen = map.get(cur+1)[1];
        		upper+=upLen;    		
        	}
        	if(map.containsKey(cur-1)) {
        		int lowLen = map.get(cur-1)[0];
        		lower+=lowLen;
        	}
        	map.put(cur, new int[] {lower,upper});
        	max=Math.max(max, Math.max(lower,upper));
        	if (map.containsKey(cur+1)) {
        		int upLen = map.get(cur+1)[1];
        		map.get(cur+upLen)[0]=map.get(cur+upLen)[0]+lower;
        		max=Math.max(max,map.get(cur+upLen)[0]);
        	}
        	if (map.containsKey(cur-1)) {
        		int lowLen = map.get(cur-1)[0];
        		map.get(cur-lowLen)[1] = map.get(cur-lowLen)[1]+upper;
        		max=Math.max(max,map.get(cur-lowLen)[1]);
        	}
        }
        return max;
    }
}
