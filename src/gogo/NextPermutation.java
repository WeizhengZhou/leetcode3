package gogo;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
        if (nums==null || nums.length <= 1) return;
        int lessIndex = -1;

        for (int i=nums.length-2;i>=0;i--){
        	if (nums[i]<nums[i+1]) {
        		lessIndex = i;
        		break;
        	}
        }
        if (lessIndex == -1) {
        	Arrays.sort(nums);
        	return;
        }
        int minLarge = Integer.MAX_VALUE;
        int minLargeIndex = -1;
        for (int i=nums.length-1;i>lessIndex;i--) {
        	if (nums[i]>nums[lessIndex]) {
        		if (nums[i]<=minLarge) {
        			minLarge = nums[i];
        			minLargeIndex = i;
        		}
        		
        	}
        }
        int temp = nums[minLargeIndex];
        nums[minLargeIndex] = nums[lessIndex];
        nums[lessIndex] = temp;
        int[] sub = Arrays.copyOfRange(nums, lessIndex+1, nums.length);
        Arrays.sort(sub);
        int j=0;
        for (int i=lessIndex+1;i<nums.length;i++) {
        	nums[i] = sub[j];
        	j++;
        }
    }
}
