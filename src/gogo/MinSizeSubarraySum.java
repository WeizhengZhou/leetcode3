package gogo;

public class MinSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int min=nums.length+1;
        int sum=0;
        int l=0;
        int r=0;
        while(r<nums.length) {
        	sum+=nums[r];
        	if (sum>=s) {
        		min=Math.min(min, r-l+1);
        		while(l<=r && sum>=s) {
        			sum-=nums[l++];
        			if (sum>=s) {
                		min=Math.min(min, r-l+1);
        			}
        		}
        	}
        	r++;
        }
        return min==nums.length+1?0:min;
    }
}
