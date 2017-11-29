package gogo;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i<nums.length; i++) {
        	if (nums[i]==i+1) continue;
        	while(
        			nums[i]!=i+1 && 
        			nums[i]-1>=0 && 
        			nums[i]-1<nums.length && 
        			nums[i] != nums[nums[i]-1]
        	) {
        		int index = nums[i]-1;
        		int temp = nums[index];
        		nums[index] = nums[i];
        		nums[i] = temp;
        	}
        }
        for (int i = 0; i<nums.length; i++) {
        	if (nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }
}
