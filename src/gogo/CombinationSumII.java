package gogo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> list = new LinkedList<>();
        if (candidates == null || candidates.length == 0) return list;
        Arrays.sort(candidates);
        helper(0, new LinkedList<Integer>(), candidates, target, list);
        return list;
    }
	private void helper(int index, List<Integer> build, int[] candidates, int target, List<List<Integer>> list) {
		if (target == 0) {
			list.add(new LinkedList<Integer> (build));
			return;
		}
		if (index >= candidates.length || target<0) return;
		int i = index;
		while (i+1<candidates.length && candidates[i]==candidates[i+1])i++;
		helper(i+1,build,candidates,target,list);
		build.add(candidates[index]);
		helper(index+1,build,candidates,target-candidates[index],list);
		build.remove(build.size()-1);
	}
}
