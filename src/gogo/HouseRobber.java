package gogo;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int[] amount = new int[nums.length];
        amount[0] = nums[0];
        amount[1] = nums[1];
        amount[1] = nums[1]>nums[0]?nums[1]:nums[0];
        for (int i=2;i<nums.length;i++) {
        	amount[i] = Math.max(amount[i-1], amount[i-2]+nums[i]);
        }
        return amount[nums.length-1];
    }
}
