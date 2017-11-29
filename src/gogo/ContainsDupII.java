package gogo;

import java.util.HashMap;
import java.util.Map;

public class ContainsDupII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums==null || nums.length<=1) return false;
        Map<Integer, Integer> map=new HashMap<> ();
        for(int i=0;i<nums.length;i++) {
        	if (map.containsKey(nums[i])) {
        		if (i-map.get(nums[i])<=k) return true;
        	}
        	map.put(nums[i], i);
        }
        return false;
    }
}
