package gogo;

public class SearchRotateSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums==null || nums.length ==0) return false;
        return bs(0,nums.length-1,nums,target);
    }
    
    private boolean bs(int l, int r, int[] nums, int target) {
    	if (l==r) return nums[l] == target;
    	if (l+1==r) {
    		if (nums[l] == target) return true;
    		return nums[r] == target;
    	}
    	int m = (l+r)/2;
    	if (nums[m] == target) return true;
    	if (nums[l]<nums[m-1]) {
    		if (nums[l]<=target && target<=nums[m-1]) {
        		return bs(l,m-1,nums,target);
        	} else {
        		return bs(m+1,r, nums, target);
        	}
    	} 
    	if (nums[m+1] < nums[r]) {
    		if (nums[m+1]<=target && target<=nums[r]) {
        		return bs(m+1,r,nums,target);
        	} else {
        		return bs(l,m-1,nums,target);
        	}
    	}
    	int left = m-1;
    	while(left>=0 && nums[left]==nums[m]) left--;
    	if (left<0) return bs(m+1,r,nums,target);
    	int right = m+1;
    	while(right<nums.length && nums[right] == nums[m]) right++;
    	if (right>=nums.length) return bs(l,m-1,nums,target);
    	return bs(m+1,r,nums,target) || bs(l,m-1,nums,target);
    }
}
