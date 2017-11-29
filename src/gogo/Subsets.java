package gogo;

import java.util.LinkedList;
import java.util.List;

public class Subsets {	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new LinkedList<> ();
        if (nums==null || nums.length ==0) return list;
        helper(0, nums,new LinkedList<Integer> (), list);
        list.add(new LinkedList<Integer> ());
        return list;
    }
	
	private void helper(int i, int[] nums, List<Integer> buffer, List<List<Integer>> list) {
		if (i>=nums.length) {
			if (!buffer.isEmpty()) {
				list.add(new LinkedList<Integer> (buffer));			
			}
			return;
		}
		helper(i+1, nums, buffer, list);
		buffer.add(nums[i]);
		helper(i+1, nums, buffer, list);
		buffer.remove(buffer.size()-1);
	}
}
