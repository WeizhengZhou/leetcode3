package Graph;
import java.util.*;
public class Graph {
	private Map<String,Node> graph = new HashMap<>();
	public Graph(int[][] A){
		for(int i=0;i<A.length;i++){
			Node u = graph.get(i+"");
			if(u == null){
				u = new Node(i+"");
				graph.put(i+"",u);
			}
			for(int j=0;j<A[0].length;j++){
				if(A[i][j] == 0) continue;
				Node v = graph.get(j+"");
				if(v == null){
					v = new Node(j+"");
					graph.put(j+"",v);
				}
				u.neigh.add(v);
			}
		}
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(String name : graph.keySet()){
			sb.append(name + " -> [");
			for(Node toNode : graph.get(name).neigh){
				sb.append(toNode.name + ", ");
			}
			sb.append("]\n");
		}
		return sb.toString();
	}
	public Map<String, Integer> computeInDegree(){
		Map<String, Integer> indeg = new HashMap<>();
		for(String from : graph.keySet()){
			Node fromNode = graph.get(from);
			if(!indeg.containsKey(from)){
				indeg.put(from,0);
			}
			for(Node toNode : fromNode.neigh){
				if(!indeg.containsKey(toNode.name)){
					indeg.put(toNode.name, 1);
				}
				else{
					indeg.put(toNode.name, indeg.get(toNode.name)+1);
				}
			}
		}
		System.out.println("Indeg = " + indeg);
		return indeg;
	}
	public void topoSort(){
		Map<String,Integer> indeg = this.computeInDegree();
		List<String> zeroIndegNodes = new ArrayList<>();
		for(String name : graph.keySet()){
			if(indeg.get(name) == 0){
				zeroIndegNodes.add(name);
			}
		}
		if(zeroIndegNodes.size() <= 0){
			System.out.println("There exists a cycle in the graph!");
			return;
		}
		
		List<String> res = new ArrayList<>();
		while(!zeroIndegNodes.isEmpty()){
			String sourceName = zeroIndegNodes.remove(0);
			indeg.remove(sourceName);
			res.add(sourceName);
			for(Node toNode:graph.get(sourceName).neigh){
				indeg.put(toNode.name, indeg.get(toNode.name)-1);
				if(indeg.get(toNode.name) == 0){
					indeg.remove(toNode.name);
					zeroIndegNodes.add(toNode.name);
				}
			}
		}
		System.out.println("Sorted = " + res);
		if(indeg.size() != 0){
			System.out.println("There is a cycle in the graph, cannot topological sort!");
		}
	}
	public void bfs(String sourceName){
		Map<String, Integer> visited = new HashMap<>();
		Node sourceNode = graph.get(sourceName);
		if(sourceNode == null){
			System.out.println("No such source node to start with!");
			return;
		}
		System.out.println("Start bfs from source = " + sourceName);
		Queue<String> queue = new LinkedList<String>();
		queue.add(sourceName);
		visited.put(sourceName, 0);
		while(!queue.isEmpty()){
			String uName = queue.remove();
			Node u = graph.get(uName);
			for(Node v : u.neigh){
				if(!visited.containsKey(v.name)){
					visited.put(v.name, visited.get(uName) + 1);
					queue.add(v.name);
				}
			}			
		}
		System.out.println(visited);
	}

	public static void main(String[] args){
		int[][] table = new int[][]{{0,1,1,0,0},
									{0,0,0,1,0},
									{0,0,0,1,0},
									{0,0,0,0,1},
									{0,0,0,0,1}};
		Graph graph = new Graph(table);
		System.out.println(graph);
		graph.topoSort();
		System.out.println();
		graph.bfs(0+"");
		
	}
}
