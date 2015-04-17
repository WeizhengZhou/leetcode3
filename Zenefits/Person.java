import java.util.HashMap;
import java.util.Map;


public class Person {
	int id;
	double lat;
	double lng;
	Map<Integer,Double> ins = null;
	public Person(int id, double lat, double lng){
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		this.ins = new HashMap<>();
	}
	public double scalarProduct(Person other){
		double weights = 0;
		for(Integer id : this.ins.keySet()){
			if(other.ins.containsKey(id) == false) 
				continue;
			weights += this.ins.get(id) * other.ins.get(id);		
		}
		return weights;
	}
	public String toString(){
		return "[id = " + this.id + ", lat = " + this.lat + ", lng = " + this.lng + "]";
	}
	public static void main(String[] args){
		Person p1 = new Person(1, 0, 0);
		p1.ins.put(1, 2.);
		
		Person p2 = new Person(2, 0, 0);
		p2.ins.put(1, 3.);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.scalarProduct(p2));
	}
}
