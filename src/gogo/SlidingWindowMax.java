package gogo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || nums.length==0) return new int[0];
        int[] result =new int[nums.length-k+1];
        PriorityQueue<Integer> q=new PriorityQueue<> (k,new Comparator<Integer> () {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
        	
        });
        int index=0;
        for(int i=0;i<nums.length;i++) {
        	q.add(nums[i]);
        	if (i>=k-1) {
        		if (i-k>=0) {
        			q.remove(nums[i-k]);
        		}
        		result[index++]=q.peek();
        	} 
        }
        return result;
    }
}
