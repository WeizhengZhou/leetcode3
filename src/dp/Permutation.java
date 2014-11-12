package dp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation p=new Permutation();
		List<List<Integer>> l=p.permute(new int[]{1,2,3});
		for(List<Integer> ll:l){
			System.out.println(ll.toString());
		}

	}

	public List<List<Integer>> permute(int[] num){
		if (num==null||num.length==0){
			return null;
		}
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		helper(num,0,res);
		return res;
	}
	
	public void helper(int[] num, int index, List<List<Integer>> res){
		if (index==num.length-1){
			List<Integer> l=new LinkedList<Integer>();
			for(int i=0;i<num.length;i++){
				l.add(num[i]);
			}
			res.add(l);
			return;
		}
		for(int i=index;i<num.length;i++){
				swap(num,index,i);
				helper(num,index+1,res);
				swap(num,index,i);
		}
	}
	
	public void swap(int[] num, int a, int b){
		if (a==b){
			return;
		}
		int temp=num[a];
		num[a]=num[b];
		num[b]=temp;
	}
}
