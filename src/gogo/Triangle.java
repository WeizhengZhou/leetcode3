package gogo;

import java.util.LinkedList;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size()==0 || triangle.get(0).size()==0) return 0;
        if (triangle.size()==1) return triangle.get(0).get(0);
        List<Integer> pre = triangle.get(triangle.size()-1);
        List<Integer> cur = new LinkedList<Integer> ();
        for (int i=triangle.size()-2;i>=0;i--) {
        	List<Integer> row = triangle.get(i);
        	for (int j=0;j<row.size();j++) {
        		cur.add(row.get(j)+Math.min(pre.get(j),pre.get(j+1)));
        	}
        	pre = new LinkedList<> (cur);
        	cur.clear();
        }
        return pre.get(0);
    }
    
    private int helper(int row, int col, List<List<Integer>> triangle) {
    	List<Integer> list = triangle.get(row);
    	if (row==triangle.size()-1) return list.get(col);
    	return Math.min(helper(row+1, col, triangle), helper(row+1,col+1,triangle)) + list.get(col);
    }
}
