package gogo;

public class IncreasingTriplelet {
	public boolean increasingTriplet(int[] nums) {
		if (nums==null || nums.length<3) return false;
		Integer min1=nums[0];
		Integer min2=null;
		for(int i=1;i<nums.length;i++) {
			int c=nums[i];
			if (c<min1) {
				min1=c;
			} else if (c==min1) {
		        continue;
		    } else if (min2==null) {
				min2=c;
			} else if (min2!=null && c>min2) {
				return true;
			} else if (min2!=null && c<min2) {
				min2=c;
			}
		}
		return false;
    }
}
