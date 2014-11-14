package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GrayCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> grayCode(int n){
		if(n==0){
			List<Integer> res0=new LinkedList<Integer>();
			res0.add(0);
			return res0;
		}
		List<StringBuilder> res=new ArrayList<StringBuilder>();
		res.add(new StringBuilder());
		List<StringBuilder> l=helper(0,n,res);
		List<Integer> list=new LinkedList<Integer>();
		for(StringBuilder sb:l){
			int t=Integer.parseInt(sb.toString(), 2);
			list.add(t);
		}
		return list;
	}
	
	List<StringBuilder> helper(int index, int n, List<StringBuilder> res){
		if(index>=n){
			return res;
		}
		List<StringBuilder> reverse=new ArrayList<StringBuilder>();
		for(int i=res.size()-1;i>=0;i--){
			StringBuilder sb=new StringBuilder(res.get(i).toString());
			res.get(i).insert(0, 0);
			sb.insert(0, 1);
			reverse.add(sb);
		}
		res.addAll(reverse);
		return helper(index+1,n,res);
	}

}
