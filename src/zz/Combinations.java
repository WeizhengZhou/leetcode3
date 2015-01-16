package zz;

import java.util.LinkedList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		if(n<=0 || k<=0){
			return res;
		}
		helper(1,0,n,k,res,new LinkedList<Integer>());
		return res;
	}
	
	public void helper(int i, int num, int n, int k,List<List<Integer>> res, List<Integer> build){
		if(num==k){
			res.add(new LinkedList<Integer>(build));
			return;
		}
		if(i>n){
			return;
		}
		helper(i+1,num,n,k,res,build);
		build.add(i);
		helper(i+1,num+1,n,k,res,build);
		build.remove(build.size()-1);
	}

}
