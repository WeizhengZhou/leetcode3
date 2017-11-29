package gogo;

public class FindMinInRotatedSortedA {
    public int findMin(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        return helper(0,nums.length-1,nums);
    }
    private int helper(int l, int r, int[] nums) {
    	if (l==r) return nums[l];
    	if (l+1==r) return nums[r]<nums[l] ? nums[r] : nums[l];
    	int midIndex = (l+r)/2;
    	int mid=nums[midIndex];
    	if (mid<nums[midIndex-1]) {
    		return mid;
    	} else if (mid<nums[l]) {
    		return helper(l,mid-1,nums);
    	} else {
    		return helper(mid+1,r,nums);
    	}
    }
}
