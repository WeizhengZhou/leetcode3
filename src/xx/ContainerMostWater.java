package xx;

public class ContainerMostWater {
	public int maxArea(int[] height) {
        if(height==null || height.length==0)return 0;
        int water=0;
        int l=0;
        int r=height.length-1;
        while(l<r){
            water=Math.max(Math.min(height[l],height[r])*(r-l),water);
            if(height[l]<height[r]){l++;}
            else{r--;}
        }
        return water;
    }

}
