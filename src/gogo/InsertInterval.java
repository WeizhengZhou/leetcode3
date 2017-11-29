package gogo;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new LinkedList<> ();
        if (intervals == null || intervals.size() == 0 || newInterval == null) {
        	list.add(newInterval);
        	return list;
        }
        Interval inject = newInterval;
        boolean injected = false;
        for (int i=0;i<intervals.size();i++) {
        	Interval cur = intervals.get(i);
        	if (injected || cur.end < inject.start) {
        		list.add(cur);
        		continue;
        	}
        	if (inject.end < cur.start) {
        		list.add(inject);
        		list.add(cur);
        		injected = true;
        		continue;
        	}
        	inject.start = Math.min(cur.start, inject.start);
        	inject.end = Math.max(cur.end,inject.end);
        }
        if (!injected) list.add(inject);
        return list;
    }
}
