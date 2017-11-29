package gogo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
	// [-2, -1, 0, 0, 1, 2]
	public List<List<Integer>> fourSum(int[] nums, int target) {
       List<List<Integer>> list = new LinkedList<> ();
       if (nums == null || nums.length < 4) return list;
       Arrays.sort(nums);
       for (int i=0; i<nums.length-3; i++) {
       	int a = nums[i];
       	if (i>0 && a == nums[i-1]) continue;
       	for (int j=i+1; j<nums.length-2; j++) {
       		int b = nums[j];
       		if (j>i+1 && b == nums[j-1]) continue;
       		int l = j+1;
       		int r = nums.length - 1;
       		while (l<r) {
       			int sum = a + b + nums[l] + nums[r];
       			if (sum == target) {
       				List<Integer> re = new LinkedList<>();
       				re.add(a);
       				re.add(b);
       				re.add(nums[l]);
       				re.add(nums[r]);
       				list.add(re);       				
       				while (l<r && nums[l]==nums[l+1]) l++;
       				l++;
       				while (l<r && nums[r]==nums[r-1]) r--;
       				r--;
       			} else if (sum < target) {
       				while (l<r && nums[l]==nums[l+1]) l++;
       				l++;
       			} else {
       				while (l<r && nums[r]==nums[r-1]) r--;
       				r--;
       			}
       		}
       	}
       }
       return list;
    }
}
