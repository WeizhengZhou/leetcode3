package dp;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		  }
	
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> res=new LinkedList<Interval>();
    	if(intervals==null||intervals.size()==0){
    		return res;
    	}    	
    	int start=intervals.get(0).start;
    	int end=intervals.get(0).end;
    	Collections.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}
    		
    	});
    	for (int i=1; i<intervals.size();i++){
    		if(end<intervals.get(i).start){
    			res.add(new Interval(start,end));
    			start=intervals.get(i).start;
    			end=intervals.get(i).end;
    		}
    		else{
    			end=Math.max(end, intervals.get(i).end);
    		}
    	}
    	res.add(new Interval(start,end));
    	return res;
    }

}
