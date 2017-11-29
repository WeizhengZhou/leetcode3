package gogo;

public class SortColors {
	public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int zero = -1;
        int two = nums.length;   
        int i=0;
        while (i<two) {
        	int c = nums[i];
        	if (c==1) {
        		i++;
        		continue;
        	}
        	if (c==0) {
        		zero++;
        		if (zero != i) {
        			int temp = nums[i];
        			nums[i] = nums[zero];
        			nums[zero] = temp;
        		}
        		i++;
        		continue;
        	}
        	if (c==2) {
        		two--;
        		if (two != i) {
        			int temp = nums[i];
        			nums[i] = nums[two];
        			nums[two] = temp;
        		}
        		continue;
        	}
        }
    }
}
