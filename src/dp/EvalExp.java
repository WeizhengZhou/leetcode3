package dp;

import java.util.Stack;

public class EvalExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int evalRPN(String[] tokens) {
        if(tokens==null||tokens.length==0){
        	return 0;
        }
        Stack<Integer> s=new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
        	String t=tokens[i];
        	if(!t.equals("+")&&!t.equals("-")&&!t.equals("*")&&!t.equals("/")){
        		s.push(Integer.parseInt(tokens[i]));
        	}
        	else{
        		int b=s.pop();
        		if(s.isEmpty()){
        			return b;
        		}
        		int a=s.pop();
        		String op=tokens[i];
        		if(op.equals("+")){
        			s.push(a+b);
        		}
        		else if(op.equals("-")){
        			s.push(a-b);
        		}
        		else if(op.equals("*")){
        			s.push(a*b);
        		}
        		else if(op.equals("/")){
        			s.push(a/b);
        		}
        	}
        }
        return s.pop();
    }
    
}
