package gogo;

public class FindMinInRotatedAII {
    public int findMin(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        return helper(0,nums.length-1,nums);
    }
    private int helper(int l, int r, int[] nums) {
    	if (nums[l]<nums[r] || l==r) return nums[l];
    	if (l+1==r) return nums[r]<=nums[l] ? nums[r] : nums[l];
    	int m = (l+r)/2;
    	int mid = nums[m];
    	if (nums[m-1] > mid) {
    		return mid;
    	} else if (nums[l]<mid) {
    		return helper(m+1,r,nums);
    	} else if (nums[l]>mid) {
    		return helper(l,m-1,nums);
    	} else {
    		return Math.min(helper(l,m-1,nums), helper(m+1,r,nums));
    	}
    }
}
