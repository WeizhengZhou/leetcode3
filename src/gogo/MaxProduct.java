package gogo;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums==null || nums.length==0) {
        	return 0;
        }
        int max=nums[0];
        int[] pos = new int[nums.length];
        int[] neg = new int[nums.length];
        int prePos = 1;
        int preNeg = 1;
        for (int i=0;i<nums.length;i++) {
        	int c=nums[i];
        	if (c==0) {
        		pos[i]=0;
        		neg[i]=0;
        		prePos=1;
        		preNeg=1;
        	} else if (c>0) {
        		pos[i] = c*prePos;
        		neg[i] = preNeg<0 ? c*preNeg : 0;
        		prePos = pos[i];
        		preNeg = neg[i]<0 ? neg[i] : 1;
        	} else {
        		pos[i] = preNeg<0 ? c*preNeg : 0;
        		neg[i] = c*prePos;
        	}
        	max = Math.max(max, pos[i]);
        }
        return max;
    }
}
