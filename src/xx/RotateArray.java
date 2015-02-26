package xx;

public class RotateArray {
	public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        if(k==0)return;
        int curValue=nums[0];
        int curIndex=0;
        int nextValue=0;
        int nextIndex=0;
        int startIndex=0;
        int count=0;
        
        while(count<n){
            nextIndex=(curIndex+k)%n;
            nextValue=nums[nextIndex];
            nums[nextIndex]=curValue;
            curValue=nextValue;
            curIndex=nextIndex;
            if(curIndex==startIndex){
                curIndex++;
                curValue=nums[curIndex];
                startIndex++;
            }
            count++;
        }
    }
}
