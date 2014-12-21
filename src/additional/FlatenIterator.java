package additional;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FlatenIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l1=new LinkedList<Integer>();
		List<Integer> l2=new LinkedList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l2.add(4);
		l2.add(5);
		Iterator<Integer> it1=l1.iterator();
		Iterator<Integer> it2=l2.iterator();
		List<Iterator<Integer>> l=new LinkedList<Iterator<Integer>>();
		l.add(it1);
		l.add(it2);
		FlatenIterator f=new FlatenIterator();
		Iterator<Integer> it=f.flattenIterator(l);
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public <T> Iterator<T> flattenIterator(List<Iterator<T>> list){
		List<T> L=new LinkedList<T>();
		boolean f=true;
		//while(f){
			for(Iterator<T> it:list){
				//f=false;
				while(it.hasNext()){
					L.add(it.next());
					f=true;
				}
		//	}
		}
		return L.iterator();
	}

}
