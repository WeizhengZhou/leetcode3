package additional_wz;
import java.util.*;
public class StackPopMostFrequent {
	private int size = 0;
	private Stack<Integer> stack = new Stack<>();
	private Map<Integer,Node> map = new HashMap<>();
	private TreeSet<Node> ts = new TreeSet<>();
	public void push(int e){
		if(!map.containsKey(e)){
			Node n = new Node(e,1);
			map.put(e,n);
			ts.add(n);			
		}
		else{
			Node n = map.get(e);
			ts.remove(n);
			n.count++;
			ts.add(n);
		}
		stack.push(e);
		size++;
	}
	public int top(){
		if(size == 0){
			return -1;
		}
		else{
			Node n = ts.first();
			return n.val;
		}
	}
	public int pop(){
		int e = stack.pop();
		Node n = map.get(e);
		ts.remove(n);
		n.count--;
		ts.add(n);
		return e;
	}
	public int size(){
		return size;
	}
	public String toString(){
		return this.map.toString();
	}
	
	public static void main(String[] args){
		StackPopMostFrequent solu = new StackPopMostFrequent();
		solu.push(1);
		solu.push(2);
		solu.push(3);
		System.out.println(solu);
		solu.push(1);
		solu.push(1);
		System.out.println(solu.top());
		
	}

}

class Node implements Comparable<Node>{
	int val = 0;
	int count = 0;
	public Node(int val, int count){
		this.val = val;
		this.count = count;
	}
	@Override 
	public int compareTo(Node other){
		return other.count - this.count;
	}	
	public String toString(){
		return "("+val+", " + count+")";
	}
}
