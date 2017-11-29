package gogo;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0) return;
        int count=0;
        int index=0;
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]==0) {
        		count++;
        	} else {
        		nums[index++]=nums[i];
        	}       	
        }
        index=nums.length-1;
        for(int i=0;i<count;i++) {
        	nums[index--]=0;
        }
    }
}
