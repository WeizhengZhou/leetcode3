package additional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
	public static void main(String[] args) {
		TopKFrequent t=new TopKFrequent();
		List<Integer> list=t.topKFrequent(new int[] {1,1,1,2,2,3}, 2);
		System.out.println(Arrays.toString(list.toArray()));
	}
	class Node {
		int val;
		int fre;
		Node(int x) {
			val=x;
			fre=0;
		}
	}
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list=new LinkedList<> ();
        if (nums==null || nums.length<k) return list;
        Map<Integer, Node> map=new HashMap<> ();
        for(int i:nums){
        	Node node=map.containsKey(i) ? map.get(i) : new Node(i);
        	node.fre++;
        	map.put(i, node);
        }
        PriorityQueue<Node> q=new PriorityQueue<> (k,new Comparator<Node> () {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o2.fre-o1.fre;
			}
        	
        });
        for(Node n:map.values()) {
        	q.add(n);
        }
        //System.out.println(q.size());
        for(int i=0;i<k;i++){
        	list.add(q.poll().val);
        }
        return list;
    }
}
