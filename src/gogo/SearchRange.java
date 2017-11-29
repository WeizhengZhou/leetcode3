package gogo;

public class SearchRange {
	public int[] searchRange(int[] nums, int target) {
		int [] re = new int[] {-1,-1};
        if (nums == null || nums.length == 0) return re;
        int start = bsStart(0, nums.length-1, target, nums);
        if (start == -1) return re;
        re[0] = start;
        re[1] = bsEnd(0,nums.length-1, target, nums);
        return re;
        	
    }
	
	private int bsStart(int l, int r, int target, int[] nums) {
		if (l==r) {
			return nums[l] == target ? l : -1;
		}
		if (l>r) {
			return -1;
		}
		int m = (l+r)/2;
		if (nums[m] ==target) {
			if ((m==0 || nums[m-1] != target)) {
				return m;
			} else {
				return bsStart(l,m-1,target,nums);
			}
			
		} else if (nums[m]<target) {
			return bsStart(m+1, r, target, nums);
		} else {
			return bsStart(l, m-1, target, nums);
		}
	}
	private int bsEnd(int l, int r, int target, int[] nums) {
		if (l==r) {
			return nums[l] == target ? l : -1;
		}
		if (l>r) {
			return -1;
		}
		int m = (l+r)/2;
		if (nums[m] ==target) {
			if (m==nums.length-1 || nums[m+1] != target) {
				return m;
			} else {
				return bsEnd(m+1,r,target,nums);
			}
			
		} else if (nums[m]<target) {
			return bsEnd(m+1, r, target, nums);
		} else {
			return bsEnd(l, m-1, target, nums);
		}
	}
}
