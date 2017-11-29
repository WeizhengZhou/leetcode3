package gogo;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int n=0;
        for(int i=0;i<nums.length;i++) {
        	n=n|nums[i];
        }
        return n;
    }
}
