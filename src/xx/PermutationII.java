package xx;
import java.util.*;
public class PermutationII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationII p=new PermutationII();
		List<List<Integer>> res=p.permuteUnique(new int[]{-1,-1,3,-1});
		for(List<Integer> l:res){System.out.println(l.toString());}
	}
	public List<List<Integer>> permuteUnique(int[] num){
		List<List<Integer>> res=new LinkedList<>();
		if(num==null || num.length==0){return res;}
		Arrays.sort(num);
		helper(0,num,res);
		return res;
	}
	private void helper(int index,int[] A,List<List<Integer>> res){
	    if(index>=A.length){
	        List<Integer> buf=new LinkedList<>();
	        for(int i=0;i<A.length;i++){ buf.add(A[i]);}
	        res.add(buf);
	        return;
	    }
	    helper(index+1,A,res);
	    int cur=A[index];
	    for(int i=index;i<A.length;i++){
	        if(cur!=A[i]){
	            swap(index,i,A);
	            helper(index+1,A,res);
	            swap(index,i,A);
	        }
	    }
	}
	private void swap(int x,int y,int[] A){
	    if(x==y) return;
	    int temp=A[x];
	    A[x]=A[y];
	    A[y]=temp;
	}
}
