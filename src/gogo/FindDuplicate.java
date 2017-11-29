package gogo;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int n=nums.length-1;
        long sum=(1+n)*n/2;
        long r=0;
        for(int i=0;i<nums.length;i++) {
        	r+=nums[i];
        }
        return (int) (r-sum);
    }
}
