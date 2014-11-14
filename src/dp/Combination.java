package dp;

import java.util.LinkedList;
import java.util.List;

public class Combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> combine(int n, int k){
		if (n==0||k==0){
			return null;
		}
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		helper(1,n,k,res,new LinkedList<Integer>());
		return res;
	}
	
	public void helper(int index, int n, int k, List<List<Integer>> res, List<Integer> list){
		if(k==0){
			res.add(new LinkedList<Integer>(list));
			return;
		}
		for(int i=index; i<=n; i++){
			list.add(i);
			helper(i+1,n,k-1,res,list);
			list.remove(list.size()-1);
		}
	}

}
