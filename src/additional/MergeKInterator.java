package additional;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKInterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l1=new LinkedList<Integer>();
		l1.add(3);
		l1.add(5);
		l1.add(7);
		Iterator<Integer> i1=l1.listIterator();
		List<Integer> l2=new LinkedList<Integer>();
		l2.add(1);
		l2.add(2);
		l2.add(8);
		Iterator<Integer> i2=l2.listIterator();
		List<Iterator<Integer>> list=new LinkedList<Iterator<Integer>>();
		list.add(i1);
		list.add(i2);
		MergeKInterator m=new MergeKInterator();
		List<Integer> r=m.mergeK(list);
		System.out.println(r.toString());

	}
	private class Node{
		int val;
		int row;
	
		public Node(int v, int a){
			val=v;
			row=a;
		}
	}
	public List<Integer> mergeK(List<Iterator<Integer>> A){
		List<Integer> res=new LinkedList<Integer>();
		if(A==null){
			return res;
		}
		int k=A.size();
		Queue<Node> q=new PriorityQueue<Node>(k,new Comparator<Node>(){

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}
			
		});
		
		for(int i=0;i<k;i++){
			q.add(new Node(A.get(i).next(),i));
		}
		while(!q.isEmpty()){
			Node min=q.poll();			
			res.add(min.val);
			int i=min.row;
			Iterator<Integer> it=A.get(i);
			if(it.hasNext()){
				q.add(new Node(it.next(),i));
			}
		}
		return res;
	}
}
