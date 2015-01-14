package zz;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		if(num==null || num.length==0){
			return res;
		}
		Arrays.sort(num);
		helper(0,num,new LinkedList<Integer>(),res);
		return res;
	}
	
	public void helper(int index, int[] num, List<Integer> list, List<List<Integer>> res){
		if(index>=num.length){
			res.add(new LinkedList<Integer>(list));
			return;
		}
		int count=1;
		int cur=num[index];
		int i=index;
		while(i+1<num.length && cur==num[i+1]){
			i++;
			count++;
		}
		helper(index+count,num,list,res);
		for(int j=0;j<count;j++){
			list.add(cur);
			helper(index+count,num,list,res);
		}
		for(int j=0;j<count;j++){
			list.remove(list.size()-1);
		}
	}
        

}
