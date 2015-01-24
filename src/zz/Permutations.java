package zz;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        if(num==null || num.length==0 ){
        	return res;
        }
        Arrays.sort(num);
        helper(0,num,res);
        return res;
    }
	
	public void helper(int index, int[] num, List<List<Integer>> res){
		if(index==num.length){
			List<Integer> list=new LinkedList<>();
			for(int i=0;i<num.length;i++){
				list.add(num[i]);
			}
			res.add(list);
		}
		for(int i=index;i<num.length;i++){
			swap(index,i,num);
			helper(index+1,num,res);
			swap(index,i,num);
		}
	}
	public void swap(int x,int y, int[] num){
		if(x==y){
			return;
		}
		int temp=num[x];
		num[x]=num[y];
		num[y]=temp;
	}

}
