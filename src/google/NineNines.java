import java.util.*;
public class NineNines {
	public void compute(){
		List<Set<Integer>> table = new ArrayList<Set<Integer>>();
		Set<Integer> set1 = new HashSet<>();
		set1.add(9);
		table.add(set1);
		for(int i=1;i<9;i++){
			Set<Integer> pre = table.get(i-1);
			Set<Integer> cur = new HashSet<>();
			for(Integer num : pre){
				cur.add(9+num);
				cur.add(9*num);
				if(num != 0)
					cur.add(9/num);
				cur.add(num/9);
				cur.add(9 - num);
				cur.add(num -9);
			}
			System.out.println(cur);
			table.add(cur);
		}
	}
	public static void main(String[] args){
		NineNines solu = new NineNines();
		solu.compute();
	}
	

}
