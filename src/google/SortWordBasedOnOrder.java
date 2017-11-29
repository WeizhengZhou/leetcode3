
import java.util.*;
public class SortWordBasedOnOrder {
	public String sort(String s, String o){
		if(s == null || o == null) return s;
	}
	private class OrderComparator implements Comparator{
		private Map<Character,Integer> map = null;
		public OrderComparator(String order){
			this.map = new HashMap<Character,Integer>();
			for(int i=0;i<order.length();i++){
				map.put(new Character(order.charAt(i)), i);
			}
		}
		@Override
		public int compare(Object o1, Object o2) {
			
			return 0;
		}
		
	}
	

}
