package additional;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BuildGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n5=new Node(5);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n8=new Node(8);
		Node n10=new Node(10);
		List<Relation> r=new LinkedList<Relation>();
		r.add(new Relation(n5,n3));
		r.add(new Relation(n3,n4));
		r.add(new Relation(n5,n8));
		r.add(new Relation(n8,n10));
		//r.add(new Relation(n4,n8));
		BuildGraph b=new BuildGraph();
		b.buildGraph(r);

	}
	
	public Node buildGraph(List<Relation> relationships){
		Map<Node,Integer> map=new HashMap<Node,Integer>();
		for(Relation r:relationships){
			Node p=r.parent;
			p.child.add(r.child);
			if(!map.containsKey(p)){
				map.put(p, 0);				
			}
			Node c=r.child;
			if(!map.containsKey(c)){
				map.put(c, 1);				
			}
			else{
				map.put(c, map.get(c)+1);
			}
		}
		Queue<Node> q=new LinkedList<Node>();
		for(Node n:map.keySet()){
			if(map.get(n)==0){
				q.add(n);
			}
		}
		if(q.size()==0){
			System.out.println("Circle!");
			return null;
		}
		if(q.size()>1){
			System.out.println("forest!");
			return null;
		}	
		Set<Node> visited=new HashSet<Node>();
		Node rt=q.peek();
		visited.add(rt);
		System.out.println(q.toString());
		Queue<Node> next=new LinkedList<Node>();
		while(!q.isEmpty()){
			Node n=q.poll();
			for(Node c:n.child){
				map.put(c,map.get(c)-1);
				if(visited.contains(c)){
					System.out.println("Graph contains circle! Not a tree! "+c.value);
				}
				visited.add(c);
				if(map.get(c)==0){
					next.add(c);
					//visited.add(c);
				}
			}
			if(q.isEmpty()){
				System.out.println(next.toString());
				q=new LinkedList<Node>(next);
				next.clear();
			}
		}
		return rt;

	}

}
