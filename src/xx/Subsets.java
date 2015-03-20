package xx;
import java.util.*;
public class Subsets {
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		if(S==null || S.length==0){
			return res;
		}
		Arrays.sort(S);
		helper(0,S,res,new LinkedList<Integer>());
		return res;
	}

	public void helper(int index,int[] S, List<List<Integer>> res, List<Integer> buf){
		if(index==S.length){
			res.add(new LinkedList<Integer>(buf));
			return;
		}
		helper(index+1,S,res,buf);
		buf.add(S[index]);
		helper(index+1,S,res,buf);
		buf.remove(buf.size()-1);
	}

}
