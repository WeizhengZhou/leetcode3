//zz reviewed
//zz explain why this algorithm works
package zz;

public class MostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maxArea(int[] height) {
		if(height==null || height.length<2){
			return 0;
		}
		int water=0;
		int left=0;
		int right=height.length-1;
		while(left<right){
			water=Math.max(water, Math.min(height[left], height[right])*(right-left));
			if(height[left]<=height[right]){
				left++;
			}
			else{
				right--;
			}
		}
		return water;
	}

}
