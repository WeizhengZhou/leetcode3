package gogo;

public class SearchRotatedArray {
	public int search(int[] nums, int target) {
        if (nums==null || nums.length==0) return -1;
        return bs(0, nums.length-1,target,nums);
    }
	
	private int bs(int l, int r, int target, int[] nums) {
		if (l==r){
			return (nums[l] == target) ? l : -1;
		}
		if (l+1==r) {
			if (nums[l]==target) return l;
            if (nums[r] ==target) return r;
            return -1;
		}
		int midIndex = (l+r)/2;
		int left = nums[l];
		int right = nums[r];
		int mid = nums[midIndex];
		if (left<mid) {
			if (left<=target && target <= mid) {
				return bs(l,midIndex,target,nums);
			} else {
				return bs(midIndex,r,target, nums);
			}
		} else {
			if (mid<=target && target <=right) {
				return bs(midIndex,r,target, nums);
			} else {
				return bs(l, midIndex, target, nums);
			}
		}
	}
}
