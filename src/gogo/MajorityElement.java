package gogo;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int count=0;
        for (int i=0;i<nums.length;i++) {
        	if(count<=0) {
        		count=0;
        		cur=nums[i];
        	}
        	if (nums[i]==cur) {
        		count++;
        	} else {
        		count--;
        	}
        }
        return cur;
    }
}
