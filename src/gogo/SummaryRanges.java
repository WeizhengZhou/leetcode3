package gogo;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list=new LinkedList<> ();
        if (nums==null || nums.length==0) return list;
        int start=nums[0];
        if (nums.length==1) {
        	list.add(String.valueOf(start));
        	return list;
        }
        for (int i=1;i<nums.length;i++) {
        	int cur=nums[i];
        	if (cur>nums[i-1]+1) {
        		if (start==nums[i-1]) {
        			list.add(String.valueOf(nums[i-1]));
        		} else {
        			list.add(start+"->"+String.valueOf(nums[i-1]));
        		}        		
        		start=cur;
        	}
        }
        if (start==nums[nums.length-1]) {
			list.add(String.valueOf(nums[nums.length-1]));
		} else {
			list.add(start+"->"+String.valueOf(nums[nums.length-1]));
		}
        return list;
    }
}
