package gogo;

public class MostWater {
	public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int l = 0;
        int r = height.length -1 ;
        int max = 0;
        while (l<r){
        	int leftH = height[l];
        	int rightH = height[r];
        	max = Math.max(max, Math.min(leftH, rightH)*(r-l));
        	if (leftH < rightH) {
        		while(height[l]<=leftH && l<r) l++;
        	} else {
        		while(height[r]<=rightH && l<r) r--;
        	}
        }
        return max;
    }
}
