package gogo;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length <2 ) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<> ();
		for (int i=0; i<nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i=0; i<nums.length; i++) {
			if (map.containsKey(target-nums[i]) && map.get(target-nums[i]) != i) {
				return new int[] {i, map.get(target-nums[i])};
			}
		}
		return null;
	}
}
