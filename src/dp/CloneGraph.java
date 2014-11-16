package dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode node= new UndirectedGraphNode(-1);
		UndirectedGraphNode n1=new UndirectedGraphNode(1);
		node.neighbors.add(n1);
		n1.neighbors.add(node);
		CloneGraph c=new CloneGraph();
		c.cloneGraph(node);

	}
	
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null){
        	return null;
        }
        List<UndirectedGraphNode> cur= new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();       
		UndirectedGraphNode cpNode=new UndirectedGraphNode(node.label);
        map.put(node, cpNode);
        cur.add(node);
        while(!cur.isEmpty()){
        	UndirectedGraphNode nd=cur.remove(0);
        	UndirectedGraphNode cp=null;
        	if (!map.containsKey(nd)){
        		cp=new UndirectedGraphNode(node.label);
                map.put(node, cp);
        	}
        	cp=map.get(nd);
        	for(UndirectedGraphNode neighbor:nd.neighbors){
            	if (!map.containsKey(neighbor)){
            		UndirectedGraphNode cpN=new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, cpN);
                    cur.add(neighbor);
            	}
            	cp.neighbors.add(map.get(neighbor));
        	}
        }
        return cpNode;
    }

}
