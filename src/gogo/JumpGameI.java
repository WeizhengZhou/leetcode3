package gogo;

public class JumpGameI {
	public boolean canJump(int[] nums) {
        if (nums==null || nums.length==0) return false;
        int dist=nums[0];
        int i=0;
        while(i<=dist) {
        	if (dist>=nums.length-1) return true;
        	dist = Math.max(dist, i+nums[i]);
        	i++;
        }
        return i>=nums.length;
    }
}
