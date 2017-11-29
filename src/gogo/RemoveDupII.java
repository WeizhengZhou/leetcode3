package gogo;

public class RemoveDupII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <=2) return 2;
        int count = 1;
        int index=0;
        for (int i=1;i<nums.length;i++) {
        	int c = nums[i];
        	if (c==nums[i-1]) {
        		count++;
        		if (count<=2) {
        			index++;
        			swap(index,i,nums);
        		} 		
        	} else {
        		index++;
        		swap(index,i,nums);
        		count = 1;
        	}   	
        }
        return index+1;
    }
    private void swap(int x, int y, int[] nums) {
    	if (x==y || nums[x]==nums[y]) return;
    	int temp = nums[x];
    	nums[x] = nums[y];
    	nums[y] = temp;
    }
}
