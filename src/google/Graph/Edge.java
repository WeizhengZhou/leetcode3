package Graph;

public class Edge {
	String from, to;
	public Edge(String from, String to){
		this.from = from;
		this.to = to;
	}
	public String toString(){
		return "(" + this.from + ", " + this.to + ")";
	}
}
