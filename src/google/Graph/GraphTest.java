package Graph;

import java.util.*;

public class GraphTest {
//	public void topologicalSort(List<Edge> edges){
//		Map<String, Integer> indegree = computeInDegree();
//		List<String> sources = this.findSource();
//		if(sources == null || sources.size() <= 0) return;
//		while(!sources.isEmpty()){
//			String sourceName = sources.remove(0);
//			Node sourceNode = graph.get(sourceName);
//			System.out.println(sourceName);
//			for(Node toNode : sourceNode.neigh){
//				indegree.put(toNode.name, indegree.get(toNode.name)-1);
//				if(indegree.get(toNode.name) == 0){
//					sources.add(toNode.name);
//				}
//			}
//		}		
//	}
//	public Map<String, Integer> computeInDegree(){
//		Map<String, Integer> indegree = new HashMap<>();
//		for(String from : graph.keySet()){
//			if(!indegree.containsKey(from)){
//				indegree.put(from, 0);
//			}
//			for(Node toNode : graph.get(from).neigh){
//				if(!indegree.containsKey(toNode.name)){
//					indegree.put(toNode.name, 1);
//				}
//				else{
//					indegree.put(toNode.name, indegree.get(toNode.name) + 1);
//				}
//			}
//		}
//		return indegree;
//	}
//	public List<String> findSource(){
//		Map<String, Integer> indegree = computeInDegree();
//		System.out.println(indegree);
//		List<String> sources = new ArrayList<>();
//		for(String name : indegree.keySet()){
//			if(indegree.get(name) == 0){
//				sources.add(name);
//			}
//		}
//		return sources;
//	}
	
//	public void buildGraph(List<Edge> edges){
//	for(Edge edge:edges){
//		String from = edge.from;
//		String to = edge.to;
//		Node fromNode = graph.get(from);
//		Node toNode = graph.get(to);
//		if(fromNode == null){
//			fromNode = new Node(from);
//			graph.put(from, fromNode);
//		}
//		if(toNode == null){
//			toNode = new Node(to);
//			graph.put(to, toNode);
//		}
//		fromNode.neigh.add(toNode);
//	}
//}
}
