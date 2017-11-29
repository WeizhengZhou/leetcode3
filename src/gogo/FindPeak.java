package gogo;

public class FindPeak {
    public int findPeakElement(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        if (nums.length==1) return 0;
        return helper(0,nums.length-1,nums);
    }
    private int helper(int l, int r, int[] nums) {
    	if (l==r) return l;
    	if (l+1==r) return nums[r]>nums[l] ? r : l;
    	int m=(l+r)/2;
    	int mid=nums[m];
    	if(nums[m-1]<mid && mid>nums[m+1]) {
    		return m;
    	} else if (nums[m-1]>mid) {
    		return helper(l,m-1,nums);
    	} else {
    		return helper(m+1,r,nums);
    	}
    }
}
