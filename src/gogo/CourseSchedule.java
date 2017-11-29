package gogo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses<=1 || prerequisites==null || prerequisites.length==0) return true;
        Map<Integer,Set<Integer>> map = new HashMap<> ();
        for(int i=0;i<prerequisites.length;i++) {
        	Set<Integer> next = map.get(prerequisites[i][1]);
        	if (next==null) next = new HashSet<> ();
        	next.add(prerequisites[i][0]);
        	map.put(prerequisites[i][1], next);
        }
        Set<Integer> visited=new HashSet<> ();
        for(int i=0;i<numCourses;i++) {
        	if (!visited.contains(i)) {
        		if (!visit(i,visited,map, new HashSet<Integer> ())) {
        			return false;
        		}
        	}
        }
        return true;
    }
    
    private boolean visit(int n, Set<Integer> visited, Map<Integer,Set<Integer>> map, Set<Integer> tmp) {
    	if(visited.contains(n)) return true;
    	if (tmp.contains(n)) return false;
    	tmp.add(n);
    	Set<Integer> child = map.get(n);
    	if (child!=null) {
        	for(Integer next: child) {
        		if(!visit(next,visited,map,tmp)) return false;
        	}
    	}
    	visited.add(n);
    	return true;
    }
}
