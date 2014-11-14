package dp;

import java.util.LinkedList;
import java.util.List;

public class Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> generateParentheses(int n){
		if (n==0){
			return null;
		}
		List<String> res=new LinkedList<String>();
		helper(0,n,n,res,new char[2*n]);
		return res;
	}
	
	public void helper(int index, int l, int r, List<String> res, char[] par){
		if(l<0||r<0){
			return;
		}
		if(l==0 && r==0){
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<par.length;i++){
				sb.append(par[i]);
			}
			res.add(sb.toString());
			return;
		}
		if(l>0){
			par[index]='(';
			helper(index+1,l-1,r,res,par);
		}
		if(l<r){
			par[index]=')';
			helper(index+1,l,r-1,res,par);
		}
	}

}
