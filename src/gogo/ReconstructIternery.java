package gogo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructIternery {
    public List<String> findItinerary(String[][] tickets) {
        List<String> list=new LinkedList<> ();
        if (tickets==null || tickets.length==0) return list;
        Map<String, PriorityQueue<String>> map=new HashMap<> ();
        for (String[] ticket:tickets) {
        	String origin=ticket[0];
        	PriorityQueue<String> q=map.containsKey(origin) ? map.get(origin) :new PriorityQueue<String> ();
        	q.add(ticket[1]);
        	map.put(origin, q);
        }
        list.add("JFK");
        dfs("JFK",0,tickets.length, map,list);
        return list;
    }
    private void dfs(String city, int index, int n, Map<String, PriorityQueue<String>> map, List<String> list) {
    	PriorityQueue<String> q=map.get(city);
    	while(q!=null && !q.isEmpty()) {
    		String des=q.poll();  		
    		dfs(des,index+1,n,map,list);    		
    	}
    	list.add(0,city);
    }
}
