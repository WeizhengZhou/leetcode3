package gogo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationII {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new LinkedList<> ();
        if (nums == null || nums.length == 0) return list;
        Arrays.sort(nums);
        helper(0, nums, list);
        return list;
    }	
	private void helper(int index, int[] nums, List<List<Integer>> list) {
		if (index >= nums.length) {
			List<Integer> re = new LinkedList<Integer> ();
			for (int i=0;i<nums.length;i++) re.add(nums[i]);
			list.add(re);
			return;
		}
		helper(index+1,nums,list);
		Set<Integer> set=new HashSet<> ();
		set.add(nums[index]);
		for (int i=index+1;i<nums.length;i++){
			if (set.contains(nums[i])) continue;
			set.add(nums[i]);
			swap(i,index,nums);
			helper(index+1,nums, list);
			swap(i,index, nums);
		}
	}
	private void swap(int i, int j, int[] nums) {
		int temp=nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
