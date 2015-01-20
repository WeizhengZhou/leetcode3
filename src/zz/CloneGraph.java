
//zz, reviewed
package zz;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//zz,O(n) time is possible, you used O(2n) time
	//zz, you can merge the two loops to make it more efficient
	 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		 if(node==null){
			 return null;
		 }
		 Queue<UndirectedGraphNode> q=new LinkedList<UndirectedGraphNode>();
		//zz, Map<Type1,Type2> map  = new HashMap<>();
		//zz, no need to declear types again
		 Map<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
		 map.put(node, new UndirectedGraphNode(node.label));
		 q.add(node);
		 while(!q.isEmpty()){
			 UndirectedGraphNode cur=q.poll();//zz, add comes with remove, offer comes with poll
			 for(UndirectedGraphNode neigbor:cur.neighbors){
				 if(!map.containsKey(neigbor)){
					 map.put(neigbor, new UndirectedGraphNode(neigbor.label));
					 q.add(neigbor);
				 }
			 }
		 }
		 for(UndirectedGraphNode n:map.keySet()){
			 UndirectedGraphNode cp=map.get(n);
			 for(UndirectedGraphNode neigbor:n.neighbors){
				 cp.neighbors.add(map.get(neigbor));
			 }
		 }
		 return map.get(node);
	 }
}
