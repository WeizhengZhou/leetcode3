package gogo;

public class TrapWater {
	public int trap(int[] height) {
        if (height == null || height.length<3) return 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int leftM = 0;
        for(int i=0;i<len; i++) {
        	leftMax[i] = leftM;
        	leftM = Math.max(leftM, height[i]);
        }
        int sum = 0;
        int rightM=0;
        for (int i=len-1;i>=0;i--) {       	
        	sum+=Math.min(leftMax[i], rightM) > height[i] ? Math.min(leftMax[i], rightM) - height[i] : 0;
        	rightM=Math.max(rightM, height[i]);
        }
        return sum;
    }
}
