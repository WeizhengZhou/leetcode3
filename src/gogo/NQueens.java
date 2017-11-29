package gogo;

import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new LinkedList<>();
        if (n<=0) return lists;
        int[] build = new int[n];
        //helper(0,n, build,lists, new HashSet<Integer> ());
        return lists;
    }
	private void helper(int index, int n, Set<Integer> set) {
		if (index>=0) {
			
		}
	}
}
