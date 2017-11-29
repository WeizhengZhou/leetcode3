package gogo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        if (nums==null ||nums.length <3) return new LinkedList<>();
        List<List<Integer>> re = new LinkedList<> ();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2;i++) {
        	if (i>0 && nums[i]==nums[i-1]) continue;
        	int comp = -nums[i];
        	int l=i+1;
        	int r = nums.length-1;
        	while(l<r) {
        		if (nums[l] + nums[r] == comp) {
        			List<Integer> list = new LinkedList<Integer>();
        			list.add(nums[i]);
        			list.add(nums[l]);
        			list.add(nums[r]);
        			re.add(list);
        			while (l<r && nums[l]==nums[l+1]) {
        				l++;
        			}
        			l++;
        			while (l<r && nums[r]==nums[r-1]) {
        				r--;
        			}
        			r--;
        		}else if (nums[l] + nums[r]<comp) {
        			while (l<r && nums[l]==nums[l+1]) {
        				l++;
        			}
        			l++;
        		} else {
        			while (l<r && nums[r]==nums[r-1]) {
        				r--;
        			}
        			r--;
        		}
        	}
        }
        return re;
    }
}
