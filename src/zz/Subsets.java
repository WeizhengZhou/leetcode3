//zz reviewed
package zz;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        if(S==null || S.length==0){
        	return res;
        }
        Arrays.sort(S);
        helper(0,S,res,new LinkedList<Integer>());
        return res;
    }
	
	public void helper(int index,int[] S, List<List<Integer>> res, List<Integer> build){
		if(index>=S.length){
			res.add(new LinkedList<Integer>(build));
			return;
		}
		helper(index+1,S,res,build);
		build.add(S[index]);
		helper(index+1,S,res,build);
		build.remove(build.size()-1);
	}


}
