package xx;
import java.util.*;
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new LinkedList<>();
	    if(candidates==null || candidates.length==0 || target<=0){return res;}
	    Arrays.sort(candidates);
	    helper(0,new LinkedList<Integer>(),candidates,target,res);
	    return res;
	}
	private void helper(int index,List<Integer> buf,int[] A,int target,List<List<Integer>> res){
	    if(target<0) {return;}
	    if(index==A.length){
	        if(target==0){
	            res.add(new LinkedList<Integer>(buf));
	        }
	        return;
	    }
	    int count=0;
	    int i=index+1;
	    while(i<A.length && A[i]==A[index]){i++;}
	    while(target>=0){
	        helper(i,buf,A,target,res); 
	        target-=A[index];
	        buf.add(A[index]);
	        count++;
	    }
	    for(int j=0;j<count;j++){
	        buf.remove(buf.size()-1);
	    }
	}
}
