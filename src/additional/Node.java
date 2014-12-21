package additional;

import java.util.LinkedList;
import java.util.List;

public class Node {
	
	int value;
	List<Node> child;
	Node(int v){
		value=v;
		child=new LinkedList<Node>();
	}
	
	public boolean equals(Object o){
		return value==((Node)o).value;
	}
	
	public String toString(){
		return ""+value;
	}

}
