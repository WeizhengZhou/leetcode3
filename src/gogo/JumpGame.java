package gogo;

public class JumpGame {
	public int jump(int[] nums) {
        if (nums == null || nums.length ==0) return 0;
        int steps = 0;
        int i=0;
        int dist= 0;
        int next = nums[0];
        while(i<=dist) {      	
        	
        	next = Math.max(next, i+nums[i]);
        	if (next>=nums.length) return steps+1;
        	i++;
        	if (i>dist) {
        		steps++;
        		dist=next;
        	}       	
        }
        return steps;
    }
	private int helper(int index, int[] steps, int[] nums) {
		if (steps[index] > 0) return steps[index];
		if (index>=nums.length) return 0;
		int min = nums.length;
		for(int i=1;i<=nums[index];i++){
			min = Math.min(min, 1+helper(index+i,steps,nums));
		}
		steps[index]=min;
		return min;
	}
}
