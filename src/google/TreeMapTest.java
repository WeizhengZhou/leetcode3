import java.util.*;
public class TreeMapTest {
	public static void main(String[] args){
		Map<Integer,String> tm = new TreeMap<>(Collections.reverseOrder());
		tm.put(1, "a");
		tm.put(2, "b");
		tm.put(3, "c");
		tm.put(4, "d");
		tm.put(5, "e");
		tm.put(6, "f");
		System.out.println(tm);
	}
}
