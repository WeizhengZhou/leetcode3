import java.util.ArrayList;
import java.util.List;

public class QuadNode {
	int size=0;
	double minLat, maxLat, minLng, maxLng;
	QuadNode n1,n2,n3,n4;
	List<Person> persons;
	public QuadNode(double minLat, double maxLat, double minLng, double maxLng) {
		this.minLat = minLat;
		this.maxLat = maxLat;
		this.minLng = minLng;
		this.maxLng = maxLng;
		this.persons = new ArrayList<>();
		this.size=0;
	}
	public int size(){
		return this.size;
	}
	public void addPerson(Person p){
		if(isLeaf() == false) return;//cannot add person to non-leaf node
		this.persons.add(p);
		this.size++;
	}
	public boolean isLeaf(){
	  return n1==null && n2==null && n3==null && n4==null;
	}
	public void divide(){
		if(this.isLeaf() == false){//cannot divide a non-leaf node
			return;
		}
		double midLat = (minLat+maxLat)/2.;
		double midLng = (minLng+maxLng)/2.;
		this.n1 = new QuadNode(minLat,midLat,minLng,midLng);//SE
		this.n2 = new QuadNode(minLat,midLat,midLng,maxLng);//SW
		this.n3 = new QuadNode(midLat,maxLat,minLng,midLng);//NE
		this.n4 = new QuadNode(midLat,maxLat,midLng,maxLng);//NE
		for(Person p : persons){
			if(n1.contains(p)){
				n1.addPerson(p);
			}
			else if(n2.contains(p)){
				n2.addPerson(p);
			}
			else if(n3.contains(p)){
				n3.addPerson(p);
			}
			else{
				n4.addPerson(p);
			}
		}
		this.persons.clear();;
	}
	public boolean contains(Person p){
		return p.lat<this.maxLat && p.lat>this.minLat && p.lng<this.maxLng && p.lng>this.minLng;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("size = " + size + ",  ");
		sb.append("Lat = [" + minLat + ", " + maxLat + "]");
		sb.append(",  ");
		sb.append("Lng = [" + minLng + ", " + maxLng + "]");
		sb.append("\n\t");
		for(Person p:persons){
			sb.append(p+",");
		}
		return sb.toString();	
	}
	public static void main(String[] args){
		QuadNode r = new QuadNode(-90,90,-180,180);
		System.out.println(r);
		r.divide();
		System.out.println(r.n1);
		System.out.println(r.n2);
		System.out.println(r.n3);
		System.out.println(r.n4);	
	}
}
