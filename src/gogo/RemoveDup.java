package gogo;

public class RemoveDup {
    public int removeDuplicates(int[] nums) {
        if (nums ==null || nums.length == 0) return 0;
        int index = 1;
        int i = 1;
        for (i = 1; i<nums.length; i++) {
        	if (nums[i-1] != nums[i]) {
        		nums[index] = nums[i];
        		index++;
        	}
        }
        return index;
    }
}
