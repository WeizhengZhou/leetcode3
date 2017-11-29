package gogo;

public class RangeSum {
	int[] sum;
    public NumArray(int[] nums) {
    	int pre=0;
    	sum=new int[nums.length];
        for(int i=0;i<nums.length;i++) {
        	pre+=nums[i];
        	sum[i]=pre;
        }
    }
    
    public int sumRange(int i, int j) {
        if (i==0) return sum[j];
        return sum[j]-sum[i-1];
    }
}
