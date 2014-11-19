package dp;

public class ContainMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxArea(int[] height) {
        if(height==null||height.length==0){
        	return 0;
        }
        int l=0;
        int r=height.length-1;
        int max=-1;
        while(l<r){
        	int s=Math.min(height[l], height[r]);
        	int w=s*(r-l);
        	max=Math.max(max, w);
        	if(s==height[l]){
        		l++;
        	}
        	else{
        		r--;
        	}
        }
        return max;
    }
}
