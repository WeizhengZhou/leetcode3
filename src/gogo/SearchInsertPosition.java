package gogo;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length==0) return 0;
        return bsHelper(0, nums.length - 1, target, nums);
    }
    
    private int bsHelper(int l, int r, int target, int[] nums){
    	if (l==r) return nums[l]>=target ? l : l+1;
    	if (l+1==r) {
    		if (nums[l]>=target) return l;
    		if (nums[r] >= target) return r;
    		return r+1;
    	}
    	int m = (l+r)/2;
    	if (nums[m]==target) {
    		return m;
    	}
    	if (m>0 && nums[m-1]<target && m<nums.length-1 && target<nums[m+1]) {
    		if (nums[m] < target) return m+1;
            else return m;
    	}
    	if (nums[m]<target) {
    		return bsHelper(m+1, r, target, nums);
    	} else {
    		return bsHelper(l, m-1, target, nums);
    	}
    	
    }
}
