package gogo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ContainsDupIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums==null || nums.length<=1 || k==0) return false;
        TreeSet<Long> set=new TreeSet<> ();
        for(int i=0;i<nums.length;i++) {
        	if (i>k) {
        		set.remove((long)nums[i-k-1]);
        	}
        	Long floor=set.floor((long)nums[i]+t);
        	if (floor!=null && floor>=nums[i]) return true;
        	Long ceiling = set.ceiling((long)nums[i]-t);
        	if (ceiling!=null && ceiling<=nums[i]) return true;
        	set.add((long)nums[i]);
        }
        return false;
    }
}
