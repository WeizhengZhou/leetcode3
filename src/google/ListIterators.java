import java.util.*;
public class ListIterators<E> {
	private int index = 0;
	private List<Iterator<E>> its = null;
	private Iterator<E> it = null;
	public ListIterators(List<Iterator<E>> its){
		this.its = its;
		index = 0;
		this.it = its.get(index);
	}
	public E next(){
		E item = null;
		it = its.get(index);
		while(!it.hasNext()){
			index = (index+1) % its.size();
			it = its.get(index);
		}
		item = it.next();
		index = (index+1) % its.size();
		return item;
	}
	public static void main(String[] args){
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list2.add(-1);
		list2.add(-2);
		list1.add(-3);
		List<Iterator<Integer>> its = new ArrayList<>();
		its.add(list1.iterator());
		its.add(list2.iterator());
		ListIterators<Integer> it = new ListIterators<Integer>(its);
		for(int i=0;i<6;i++){
			System.out.println(it.next());
		}
	}
}
