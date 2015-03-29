import java.util.*;

public class ReconstructTrip {
	public void reconstruct(List<Edge> edges){
		if(edges == null) return;
		Map<String,Node> nodes = buildNodes(edges);
		Set<Node> zeroInDegreeNodes = findSource(nodes);
		Queue<Node> queue = new ArrayList<Node>(zeroInDegreeNodes);
		
		
	}
	private Map<String,Node> buildNodes(List<Edge> edges){
		Map<String,Node> map = new HashMap<>();
		for(Edge edge:edges){
			Node fromNode = map.get(edge.from);
			Node toNode = map.get(edge.to);
			if(fromNode == null){
				fromNode = new Node(edge.from);
				map.put(edge.from, fromNode);
			}
			if(toNode == null){
				toNode = new Node(edge.to);
				map.put(edge.from, toNode);
			}
			fromNode.neigh.add(toNode);
		}
		return map;
	}
	private Set<Node> findSource(Map<String, Node> map){
		Set<Node> zeroInDegreeNodes = new HashSet<>();
		for(String name : map.keySet()){
			zeroInDegreeNodes.add(map.get(name));
		}
		for(String name:map.keySet()){
			for(Node n:map.get(name).neigh){
				if(zeroInDegreeNodes.contains(n)){
					zeroInDegreeNodes.remove(n);
				}
			}
		}
		return zeroInDegreeNodes;
	}
}

