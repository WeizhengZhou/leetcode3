import java.util.*;	
public class FlattenIteratorList implements Iterator{
	private int index;
	private List<Iterator<Integer>> its = null;
	private Iterator<Integer> it = null;
	
	public FlattenIteratorList(List<Iterator<Integer>> its){
		assert its != null;
		this.its = its;
		this.index = 0;
		this.it = its.get(0);
	}
	public boolean hasNext() {
		if(it.hasNext()) 
			return true;
		else if(index == its.size()-1)
			return false;
		else{
			index++;
			while(index < its.size()){
				it = its.get(index);
				if(it.hasNext()) break;
				index++;
			}
			if(index >= its.size()) 
				return false;
			else
				return it.hasNext();
		}
	}
	public Integer next() throws NoSuchElementException{
		if(it.hasNext()) return it.next();
		else
			throw new NoSuchElementException();
	}
	public void remove() {
		System.out.println("Operation Not Supported!");		
	}
	public static void main(String[] args){
		List<Iterator<Integer>> its = new ArrayList<Iterator<Integer>>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(3);
		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(4);
		its.add(list1.iterator());
		its.add(list2.iterator());
		FlattenIteratorList solu = new FlattenIteratorList(its);
		while(solu.hasNext()){
			System.out.println(solu.next());
		}	
	}
}

