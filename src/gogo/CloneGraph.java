package gogo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null) return null;
        Queue<UndirectedGraphNode> q = new LinkedList<> ();
        Set<UndirectedGraphNode> visited = new HashSet<> ();
        q.add(node);
        visited.add(node);
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<> ();
        while(!q.isEmpty()) {
        	UndirectedGraphNode cur = q.poll();
        	UndirectedGraphNode copy = new UndirectedGraphNode(cur.label);
        	map.put(cur, copy);
        	for(UndirectedGraphNode n:cur.neighbors) {
        		if (!visited.contains(n)) {
        			q.add(n);
        			visited.add(n);
        		}   		
        	}
        }
        for(UndirectedGraphNode cur:map.keySet()) {
        	UndirectedGraphNode copy=map.get(cur);
        	List<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>();
        	for(UndirectedGraphNode n:cur.neighbors) {
        		list.add(map.get(n));
        	}
        	copy.neighbors=list;
        }
        return map.get(node);
    }
}
