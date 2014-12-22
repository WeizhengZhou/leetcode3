package additional;

import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class FrequencyStack {

	class Node{
		int value;
		int frequency;
		Node(int x){
			value=x;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrequencyStack f=new FrequencyStack();
		f.push(3);
		f.push(2);
		f.push(2);
		f.push(1);
		f.push(3);
		f.push(3);
		System.out.println(f.getMostFrequent());//3
		System.out.println("pop="+f.pop());//3
		System.out.println(f.getMostFrequent());//2
		System.out.println("pop="+f.pop());//3
		System.out.println(f.getMostFrequent());//2
		System.out.println("pop="+f.pop());//1
		System.out.println(f.getMostFrequent());//2
		System.out.println("pop="+f.pop());//2
		System.out.println(f.getMostFrequent());//2
		System.out.println("pop="+f.pop());//2
		System.out.println(f.getMostFrequent());//3
		System.out.println("pop="+f.pop());//3
		//System.out.println(f.getMostFrequent());
		/*PriorityQueue<Integer> pq=new PriorityQueue<Integer>(100,new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
			
		});
		pq.add(3);
		pq.add(2);
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		*/
	}
	Stack<Integer> stack=new Stack<Integer>();
	Map<Integer,Node> map=new HashMap<Integer,Node>();
	PriorityQueue<Node> q=new PriorityQueue<Node>(100,new Comparator<Node>(){

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o2.frequency!=o1.frequency?o2.frequency-o1.frequency:o1.value-o2.value;
		}
		
	});
	
	public void push(int x){
		stack.push(x);
		if(map.containsKey(x)){
			Node n=map.get(x);
			q.remove(n);
			n.frequency=n.frequency+1;
			q.add(n);
			//System.out.println(x+" node frequency="+n.frequency);
		}
		else{
			Node n=new Node(x);
			n.frequency=1;
			map.put(x, n);
			q.add(n);
			//System.out.println(x+" node frequency="+n.frequency);
		}		
	}
	
	public int pop(){
		if(stack.isEmpty()){
			throw new EmptyStackException();
		}
		int p=stack.pop();
		Node n=map.get(p);
		if(n.frequency==1){
			q.remove(n);
			map.remove(p);
		}
		else{
			q.remove(n);
			n.frequency=n.frequency-1;
			q.add(n);
		}
		//System.out.println(n.value+" node frequency="+n.frequency);
		return p;
	}
	
	public int getMostFrequent(){
		if(stack.isEmpty()){
			throw new EmptyStackException();
		}
		Node n=q.peek();
		//System.out.println(n.value+" node frequency="+n.frequency);
		return n.value;
	}

}

