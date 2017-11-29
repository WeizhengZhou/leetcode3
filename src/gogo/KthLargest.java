package gogo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums==null || nums.length==0) return 0;
        PriorityQueue<Integer> p=new PriorityQueue<> (nums.length, new Comparator<Integer> () {
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
        	
        });
        for(int i=0;i<nums.length;i++){
        	p.add(nums[i]);
        }
        int r=0;
        for(int i=0;i<k;i++){
        	r=p.poll();
        }
        return r;
    }
}
