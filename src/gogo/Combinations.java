package gogo;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new LinkedList<> ();
        if (n<=0 || k<=0) return list;
        helper(1,n,k,new LinkedList<Integer> (), list);
        return list;
    }
	
	private void helper(int i, int n, int k, List<Integer> buffer, List<List<Integer>> list) {
		if (k==0) {
			if (!buffer.isEmpty()) {
				list.add(new LinkedList<Integer> (buffer));
				return;
			}
		}
		if (i>n) return;
		helper(i+1, n, k, buffer, list);
		buffer.add(i);
		helper(i+1, n, k-1, buffer, list);
		buffer.remove(buffer.size()-1);
	}
	
}
