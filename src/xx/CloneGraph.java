package xx;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){return null;}
        Map<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<>();
        Queue<UndirectedGraphNode> queue=new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode cur=queue.poll();
            UndirectedGraphNode copy=map.get(cur);
            if(copy==null){
                copy=new UndirectedGraphNode(cur.label);
                map.put(cur,copy);
            }
            for(UndirectedGraphNode neighbor:cur.neighbors){
                UndirectedGraphNode neighborCopy=map.get(neighbor);
                if(neighborCopy==null){
                    neighborCopy=new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor,neighborCopy);
                    queue.add(neighbor);
                }
                copy.neighbors.add(neighborCopy);
            }
        }
        return map.get(node);
    }
}
