package zz;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> resBuf=new LinkedList<Interval>();
		if(intervals==null || intervals.size()==0){
			return resBuf;
		}
		Collections.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}});
		int listLen=intervals.size();
		int i=0;
		int mergeStart=Integer.MAX_VALUE;
		int mergeEnd=intervals.get(0).end;
		boolean set=false;
		for(;i<listLen-1;i++){
			Interval cur=intervals.get(i);
			Interval next=intervals.get(i+1);			
			if(next.start>mergeEnd){
				if(set){					
					resBuf.add(new Interval(mergeStart,mergeEnd));
					set=false;
				}
				else{
					resBuf.add(cur);
				}
				mergeEnd=cur.end;
			}
			if(next.start<=mergeEnd){
				set=true;
				mergeStart=Math.min(mergeStart, cur.start);
				mergeEnd=Math.max(mergeEnd, Math.max(cur.end, next.end));
			}
		}
		if(set){					
			resBuf.add(new Interval(mergeStart,mergeEnd));
		}
		else{
			resBuf.add(intervals.get(i));
		}
		return resBuf;
	}

}
