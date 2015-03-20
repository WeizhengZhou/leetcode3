package xx;

import java.util.*;
public class Permutation {
	public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res=new LinkedList<>();
        if(num==null || num.length==0)return res;
        helper(0,num,res);
        return res;
	}
	private void helper(int index,int[] A, List<List<Integer>> res){
	    if(index==A.length){
	        List<Integer> buf=new LinkedList<>();
	        for(int i=0;i<A.length;i++) buf.add(A[i]);
	        res.add(buf);
	        return;
	    }
	    for(int i=index;i<A.length;i++){
	        swap(i,index,A);
	        helper(index+1,A,res);
	        swap(i,index,A);
	    }
	}
	private void swap(int x,int y,int[] A){
	    int temp=A[x];
	    A[x]=A[y];
	    A[y]=temp;
	}
}
