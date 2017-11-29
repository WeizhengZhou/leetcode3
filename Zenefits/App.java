import java.util.*;


public class App {
	QuadTree qt = null;
	Map<Integer, Person> map = null;
	public App(){
		this.qt = new QuadTree();
		this.map = new HashMap<>();
	}
	public void add(){
		
	}
	public void query(int id, double dist){
		Person p = this.map.get(id);
		List<Person> possiblePersons = this.qt.collectPossiblePersons(p, dist);	
		List<Person> topPersons = findTopPersons(possiblePersons,p);
	}
	public List<Person> findTopPersons(List<Person> persons, final Person p){
		PriorityQueue<Person> pq = new PriorityQueue<>(10, new Comparator<Person>(){
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				double w1 = p.scalarProduct(o1);
				double w2 = p.scalarProduct(o2);
				return (int) (w2-w1);		
			}		
		});
		//TODO		
	}
}
