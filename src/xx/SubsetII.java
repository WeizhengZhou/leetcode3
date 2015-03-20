package xx;
import java.util.*;
public class SubsetII {
	public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res=new LinkedList<>();
        if(num==null || num.length==0)return res;
        Arrays.sort(num);
        helper(0,new LinkedList<>(), num,res);
        return res;
	}
	private void helper(int index,List<Integer> buf, int[] A,List<List<Integer>> res){
	    if(index==A.length){res.add(new LinkedList<Integer>(buf));return;}
	    int i=index+1;
	    while(i<A.length && A[i]==A[index]){i++;}
	    helper(i,buf,A,res);
	    for(int j=0;j<i-index;j++){
	        buf.add(A[index]);
	        helper(i,buf,A,res);
	    }
	    for(int j=0;j<i-index;j++){buf.remove(buf.size()-1);}
	}
}
