package gogo;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        return Math.max(helper(0,nums.length-2,nums), helper(1,nums.length-1,nums));
    }
    private int helper(int l, int r, int[] nums) {
    	if (l>r) return 0;
    	if (l==r) return nums[l];
    	int first=nums[l];
    	int second = nums[l+1]>nums[l] ? nums[l+1]:nums[l];
    	for(int i=l+2;i<=r;i++) {
    		int next=Math.max(first+nums[i], second);
    		first=second;
    		second=next;
    	}
    	return second;
    }
}
