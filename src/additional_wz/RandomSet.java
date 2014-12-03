
import java.util.*;
public class RandomSet {
	private int capacity = 0;
	private int size = 0;
	private Map<Integer,Integer> map = null;
	private int[] A = null;
	public RandomSet(int capacity){
		this.capacity = capacity;
		map = new HashMap<>(capacity);
		A = new int[capacity];
	}
	public void add(int e){
		if(size >= capacity) 
			return;
		else if(!map.containsKey(e)){
			map.put(e, size);
			A[size] = e;
			size++;
		}
	}
	public void remove(int e){
		if(size <= 0)
			return;
		else{
			int index = map.get(e);
			A[index] = A[size-1];
			map.put(A[size-1], index);
			map.remove(e);
			size--;
		}
	}
	public int getRandom(){
		int index = (int) (size * Math.random());
		return A[index];
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(map);
		sb.append("\n");
		sb.append(Arrays.toString(A));
		return sb.toString();
	}	
	public static void main(String[] args){
		 RandomSet rs = new RandomSet(10);
		 rs.add(1);
		 rs.add(5);
		 rs.add(4);
		 rs.add(3);
		 rs.add(2);
		 System.out.println(rs);
//		 rs.remove(5);
		 System.out.println(rs);
		 System.out.println(rs.getRandom());
		 System.out.println(rs.getRandom());
		 System.out.println(rs.getRandom());
		 System.out.println(rs.getRandom());
		
	}

}
