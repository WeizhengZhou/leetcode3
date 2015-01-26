package zz;

import java.util.Stack;

public class ValidParen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public boolean isValid(String s) {
		 if(s==null || s.length()==0){
			 return false;
		 }
		 Stack<Character> stack=new Stack<>();
		 for(int i=0;i<s.length();i++){
			 char cur=s.charAt(i);
			 if(cur=='('||cur=='['||cur=='{'){
				 stack.push(cur);
			 }
			 else{
				 if(stack.isEmpty()){
					 return false;
				 }
				 char pre=stack.peek();
				 if()
			 }
					 
		 }
	 }

}
