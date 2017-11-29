package gogo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class MergeInterval {
	public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}});
        List<Interval> list = new LinkedList<> ();
        for (int i=0;i<intervals.size();i++) {
        	Interval cur = intervals.get(i);
        	if (list.isEmpty()) {
        		list.add(cur);
        		continue;
        	}
        	Interval last=list.get(list.size()-1);
        	if (last.end<cur.start) {
        		list.add(cur);
        		continue;
        	}
        	list.remove(list.size()-1);
        	list.add(new Interval(Math.min(cur.start, last.start),Math.max(cur.end, last.end)));
        }
        return list;
    }
}
