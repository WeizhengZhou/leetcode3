package xx;
import java.util.*;
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res=new LinkedList<>();
		if(candidates==null || candidates.length==0 || target<0){return res;}
		Arrays.sort(candidates);
		helper(0,candidates,new LinkedList<Integer>(),res,target);
		return res;
	}
	private void helper(int index,int[] A,List<Integer> buf,List<List<Integer>> res,int target){
	    if(target==0){
	        res.add(new LinkedList<Integer>(buf));
	        return;
	    }
	    if(target<0){return;}
	    if(index>=A.length){return;}
	    int cur=A[index];
	    int next=index+1;
	    while(next<A.length && A[next]==cur){next++;}
	    helper(next,A,buf,res,target);
	    for(int i=0;i<next-index;i++){
	        buf.add(cur);
	        target-=cur;
	        helper(next,A,buf,res,target);
	    }
	    for(int i=0;i<next-index;i++){buf.remove(buf.size()-1);}
	}
}
