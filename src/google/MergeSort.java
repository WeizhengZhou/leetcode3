import java.util.*;


public class MergeSort {
	public void sort(List<Iterator<Integer>> its){
		if(its == null || its.size() == 0) return;
		PriorityQueue<Entry> pq = new PriorityQueue<>();
		for(int i=0;i<its.size();i++){
			Iterator<Integer> it = its.get(i);
			if(it.hasNext()){
				Entry e = new Entry(it,it.next());
				pq.add(e);
			}
		}
		while(!pq.isEmpty()){
			Entry cur = pq.remove();
			System.out.print(cur.data + ", ");
			if(cur.it.hasNext()){
				Entry next = new Entry(cur.it,cur.it.next());
				pq.add(next);
			}
		}
	}
	public static void main(String[] args){
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(5);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(3);
		list2.add(7);
		
		List<Iterator<Integer>> its = new ArrayList<Iterator<Integer>>();
		its.add(list1.iterator());
		its.add(list2.iterator());
		
		new MergeSort().sort(its);
		
		
		
	}
}
class Entry implements Comparable<Entry>{
	int data;
	Iterator<Integer> it = null;
	public Entry(Iterator<Integer> it, int data){
		this.it = it;
		this.data = data;
	} 
	@Override
	public int compareTo(Entry other) {
		return this.data - other.data;
	}
}
