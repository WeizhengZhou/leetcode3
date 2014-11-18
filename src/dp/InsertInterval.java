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
    	boolean set=false;
    	while(i<intervals.size()){
    		int lastend=i==0?-1:intervals.get(i-1).end;
    		if (newInterval.start>=intervals.get(i).start && newInterval.start<=intervals.get(i).end||newInterval.start<=intervals.get(i).start&&newInterval.start>lastend&&newInterval.end>=intervals.get(i).start){
    			start=Math.min(intervals.get(i).start, newInterval.start);
    			end=Math.max(intervals.get(i).end, newInterval.end);
    			set=true;
    		}
    		if (newInterval.start<=intervals.get(i).start&&newInterval.start>lastend&&newInterval.end<intervals.get(i).start){
    			res.add(newInterval);
    		}
    		if (!set){
    			res.add(intervals.get(i));   			
    		}
    		else{
    			if (end<intervals.get(i).start){
    				res.add(new Interval(start,end));
    				set=false;
    				res.add(intervals.get(i));
    			}
    			else{
    				end=Math.max(end,intervals.get(i).end);
    			}
    		}
    		i++;
    	}
    	if (set){
    		res.add(new Interval(start,end));
    	}
    	if (newInterval.start>intervals.get(intervals.size()-1).end){
    		res.add(newInterval);
    	}
    	return res;
    }
}
