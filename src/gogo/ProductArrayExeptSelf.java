package gogo;

public class ProductArrayExeptSelf {
    public int[] productExceptSelf(int[] nums) {
    	int len = nums.length;
        int[] left=new int[len];
        int[] right=new int[len];
        left[0] = nums[0];
        for (int i=1;i<len;i++) {
        	left[i] = left[i-1]*nums[i];
        }
        right[len-1] = nums[len-1];
        for (int i=len-2;i>=0;i--) {
        	right[i]=right[i+1]*nums[i];
        }
        int[] r=new int[len];
        r[0] = right[1];
        r[len-1]=left[len-2];
        for(int i=1;i<len-1;i++) {
        	r[i] = left[i-1]*right[i+1];
        }
        return r;
    }
}
