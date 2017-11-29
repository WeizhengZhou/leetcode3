package gogo;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new LinkedList<> ();
        if (candidates == null || candidates.length == 0) return list;
        helper(0,new LinkedList<Integer> (),target,candidates,list);
        return list;
    }
	
	private void helper(int index, List<Integer> build, int target, int[] candidates, List<List<Integer>> list) {
		if (target == 0) {
			list.add(new LinkedList<Integer>(build));
			return;
		}
		if (index>=candidates.length) return;
		helper(index+1,build,target,candidates,list);
		int t = target;
		int c = candidates[index];
		int count=0;
		while(t>=c) {
			t=t-c;
			count++;
			build.add(c);
			helper(index+1,build,t,candidates,list);
		}
		for(int i=0; i<count; i++) {
			build.remove(build.size()-1);
		}
	}
}
