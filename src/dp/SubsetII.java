package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubsetII s=new SubsetII();
		List<List<Integer>> l=s.subset(new int[]{1,2,2});
		for(List<Integer> ll:l){
			System.out.println(ll.toString());
		}
	}
	
	public List<List<Integer>> subset(int[] S){
		if(S==null||S.length==0){
			return null;
		}
		Arrays.sort(S);
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		helper(S,0,res,new LinkedList<Integer>());
		return res;
	}
	
	public void helper(int[] s,int index, List<List<Integer>> res, List<Integer> list){
		if (index==s.length){
			res.add(new LinkedList<Integer>(list));
			return;
		}
		int count=1;
		while((index+count)<s.length && s[index]==s[index+count]){
			count++;
		}
		helper(s,index+count,res,list);
		for (int i=0; i<count;i++)
		{		
			list.add(s[index]);
			helper(s,index+count,res,list);
		}
		for (int i=0; i<count; i++)
		{
			list.remove(list.size()-1);
		}
		
	}

}
