package gogo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	PriorityQueue<Integer> large;
	PriorityQueue<Integer> small;
    /** initialize your data structure here. */
    public MedianFinder() {
    	large=new PriorityQueue<> ();
    	small=new PriorityQueue<> (100, new Comparator<Integer> () {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}});
    }
    
    public void addNum(int num) {

    	Integer max=large.peek();
    	Integer min=small.peek();
    	if (max==null || num>=max){
    		large.add(num);
    	} else {
    		small.add(num);
    	}
        
        if (small.size()>large.size()) {
        	large.add(small.poll());
        } else if (large.size()>small.size()+1) {
        	small.add(large.poll());
        }
    }
    
    public double findMedian() {
        if ((large.size()+small.size())%2==1) return large.peek();
        else return (large.peek()+small.peek())/2.0;
    }
}
