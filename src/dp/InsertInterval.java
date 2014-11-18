package dp;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		  }
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> res=new LinkedList<Interval>();
    	if (intervals==null || intervals.size()==0){
    		res.add(newInterval);
    		return res;
    	}
    	int start=0;
    	int end=0;
    	int i=0;
    	while(i<intervals.size()){
    		if (newInterval.start>=intervals.get(i).start && newInterval.start<=intervals.get(i).end){
    			start=intervals.get(i).start;
    			end=Math.max(intervals.get(i).end, newInterval.end);
    		}
    		if (start==0){
    			res.add(intervals.get(i));   			
    		}
    		else{
    			if (end<intervals.get(i).start){
    				res.add(new Interval(start,end));
    				start=0;
    				res.add(intervals.get(i));
    			}
    			else{
    				end=Math.max(end,intervals.get(i).end);
    			}
    		}
    		i++;
    	}
    	if (start!=0){
    		res.add(new Interval(start,end));
    	}
    	if (newInterval.start>intervals.get(intervals.size()-1).end){
    		res.add(newInterval);
    	}
    	return res;
    }
}
