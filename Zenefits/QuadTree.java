import java.util.*;
public class QuadTree {
	final double RADUIS_EARTH = 4000;//4000 miles 
	final int NODE_SIZE=2;
	QuadNode root;
	public QuadTree(){
		this.root = new QuadNode(-90.,90.,-180.,180.);
	}
	public void addPerson(Person p){
		QuadNode cur = root;
		while(cur.isLeaf() == false){
			cur.size++;
			if(cur.n1.contains(p) == true){
				cur = cur.n1;
			}
			else if(cur.n2.contains(p) == true){
				cur = cur.n2;
			}
			else if(cur.n3.contains(p) == true){
				cur = cur.n3;
			}
			else{
				cur = cur.n4;
			}
		}
		cur.addPerson(p);
		if(cur.size() > NODE_SIZE){
			cur.divide();
		}
	}
	public List<Person> collectPossiblePersons(Person p, double dist){
		List<Person> res = new ArrayList<>();
		dfs(p, root, res, dist);
		return res;		
	}
	private void dfs(Person p, QuadNode root, List<Person> res, double dist){
		if(root == null) return;
		if(root.isLeaf() == true) res.addAll(root.persons);
		double degree = this.distToDegree(dist);
		if(intersect(p, root.n1, degree) == true){
			dfs(p, root.n1, res, dist);
		}
		if(intersect(p, root.n2, degree) == true){
			dfs(p, root.n2, res, dist);
		}
		if(intersect(p, root.n3, degree) == true){
			dfs(p, root.n3, res, dist);
		}
		if(intersect(p, root.n4, degree) == true){
			dfs(p, root.n4, res, dist);
		}
	}
	private boolean intersect(Person p, QuadNode qn, double distance){
		//ToDo
		return false;
	}
	private double distToDegree(double dist){
		return dist/Math.PI/2/RADUIS_EARTH ;
	}
	public static void main(String[] args){
		Person p1 = new Person(1, -1, -1);
		Person p2 = new Person(2, -1, 1);
		Person p3 = new Person(3, 1, -1);
		Person p4 = new Person(4, 1, 1);
		Person p5 = new Person(5, 2, 1);
		Person p6 = new Person(6, 3, 1);

		QuadTree qt = new QuadTree();
		qt.addPerson(p1);
		qt.addPerson(p2);
		qt.addPerson(p3);
		qt.addPerson(p4);
		qt.addPerson(p5);
		qt.addPerson(p6);
		
		System.out.println(qt.root);
		System.out.println(qt.root.n1);
		System.out.println(qt.root.n2);
		System.out.println(qt.root.n3);
		System.out.println(qt.root.n4);
		System.out.println("       " + qt.root.n4.n1);
		System.out.println("       " + qt.root.n4.n2);
		System.out.println("       " + qt.root.n4.n3);
		System.out.println("       " + qt.root.n4.n4);				
	}	
}
