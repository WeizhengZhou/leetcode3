package gogo;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
    	if (nums==null || nums.length==0) return 0;  
    	int single=0;
    	for (int i=0;i<32;i++) {
    		int sum=0;
    		for (int j=0;j<nums.length;j++) {
    			int bit = nums[j]>>i & 1;
    			sum+=bit;
    			sum=sum % 3;
    		}
    		if (sum==1) {
    			single+=1<<i;
    		}
    	}
    	return single;
    }
}
