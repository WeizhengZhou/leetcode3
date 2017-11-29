package gogo;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int index = 0;
        for (int i=0;i<nums.length;i++) {
        	if (nums[i] != val) {
        		nums[index] = nums[i];
        		index++;
        	}
        }
        return index;
    }
}
