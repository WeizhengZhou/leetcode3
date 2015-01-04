package zz;

import java.util.Stack;

public class EvaluateExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int evalRPN(String[] tokens) {
		if(tokens==null || tokens.length==0){
			return 0;
		}
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<tokens.length;i++){
			String c=tokens[i];
			if(!c.equals("+") && !c.equals("-") && !c.equals("*") && !c.equals("/")){
				stack.push(Integer.parseInt(c));
			}
			else{
				int b=stack.pop();
				int a=stack.pop();
				int res=0;
				if(c.equals("+")){
					res=a+b;
				}
				else if(c.equals("-")){
					res=a-b;
				}
				else if(c.equals("*")){
					res=a*b;
				}
				else if(c.equals("/")){
					res=a/b;
				}
				stack.push(res);
			}
		}
		return stack.peek();
	}
}
