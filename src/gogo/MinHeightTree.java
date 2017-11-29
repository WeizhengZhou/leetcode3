package gogo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list=new LinkedList<> ();
        if (n==1) {
            list.add(0);
            return list;
        }
        if (edges==null || edges.length==0 || edges[0]==null) return list;
        
        Map<Integer,List<Integer>> map=new HashMap<> ();
        for(int i=0;i<n;i++){
        	map.put(i,new LinkedList<Integer> ());
        }
        List<Integer> leaves=new LinkedList<> ();
        for(int i=0;i<edges.length;i++){
        	map.get(edges[i][0]).add(edges[i][1]);
        	map.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0;i<n;i++) {
        	if (map.get(i).size()==1) leaves.add(i);
        }
        while(n>2) {
        	n-=leaves.size();
        	List<Integer> next=new LinkedList<> ();
        	for(Integer i: leaves) {
        		int node=map.get(i).get(0);
        		map.remove(i);
        		map.get(node).remove(i);
        		if(map.get(node).size()==1) next.add(node);
        	}
        	leaves=next;
        }
        return leaves;
    }
}
