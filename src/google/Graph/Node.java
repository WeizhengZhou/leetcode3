package Graph;

import java.util.*;
public class Node {
	String name;
	List<Node> neigh = new ArrayList<>();
	public Node(String name){
		this.name = name;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.name + " : ");
		for(Node n:this.neigh){
			sb.append(n.name + ", ");
		}
		return sb.toString();
	} 
}
