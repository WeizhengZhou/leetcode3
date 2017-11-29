package gogo;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (k==0 || nums==null || nums.length==0) return;
        k=k%nums.length;
        int[] temp = Arrays.copyOfRange(nums, nums.length-k, nums.length);
        int j=nums.length;
        for (int i=nums.length-k-1;i>=0;i--) {
        	nums[j--] = nums[i];
        }
        for(int i=k-1;i>=0;i--){
        	nums[i] = temp[i];
        }
    }
}
