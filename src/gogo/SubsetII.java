package gogo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new LinkedList<> ();
        if (nums==null || nums.length==0) return list;
        Arrays.sort(nums);
        helper(0,nums, new LinkedList<Integer> (), list);
        return list;
    }
	
	private void helper(int index, int[] nums, List<Integer> build, List<List<Integer>> list) {
		if (index>=nums.length) {
			list.add(new LinkedList<Integer> (build));
			return;
		}
		int next = index+1;
		int count = 1;
		while(next<nums.length && nums[next]==nums[index]) {
			count++;
			next++;
		}
		helper(next,nums,build,list);
		for (int i=0;i<count;i++) {
			build.add(nums[index]);
			helper(next,nums,build,list);
		}
		for (int i=0;i<count;i++) {
			build.remove(build.size()-1);
		}
	}
}
