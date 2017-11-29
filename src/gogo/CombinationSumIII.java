package gogo;

import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
    	List<List<Integer>> list=new LinkedList<> ();
        if (k<=0 || n<=0) return list;
        helper(1,k,n,new LinkedList<Integer> (), list);
        return list;
    }
    
    private void helper(int cur, int k, int sum, List<Integer> buffer, List<List<Integer>> list) {
    	if (k==0) {
    		if (sum==0) {
    			list.add(new LinkedList<Integer> (buffer));
    		}
    		return;
    	}
    	if (cur>=10) return;
    	if (cur>sum) return;
    	helper(cur+1, k, sum, buffer,list);
    	buffer.add(cur);
    	helper(cur+1,k-1,sum-cur,buffer,list);
    	buffer.remove(buffer.size()-1);
    }
}
