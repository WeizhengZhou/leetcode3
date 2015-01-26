package zz;

import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public List<String> generateParenthesis(int n) {
		 List<String> res=new LinkedList<>();
		 if(n<=0){
			 return res;
		 }
		 helper(0,n,n,new char[2*n],res);
		 return res;
	 }
	 
	 public void helper(int index, int leftP, int rightP, char[] buf, List<String> res){
		 if(leftP==0 && rightP==0){
			 res.add(new String(buf));
			 return;
		 }
		 if(rightP==0){
			 return;
		 }
		 if(leftP>0){
			 buf[index]='(';
			 helper(index+1,leftP-1,rightP,buf,res);
		 }
		 if(leftP<rightP){
			 buf[index]=')';
			 helper(index+1,leftP,rightP-1,buf,res);
		 }
	 }

}
