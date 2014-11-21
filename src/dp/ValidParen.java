package dp;

import java.util.Stack;

public class ValidParen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isValid(String s) {
        if(s==null||s.length()==0){
        	return true;
        }
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
        	char c=s.charAt(i);
        	if(c=='('||c=='{'||c=='['){
        		stack.push(c);
        	}
        	else if(stack.isEmpty()){
        		return false;
        	}
        	else{
        		char l=stack.peek();
        		if(l!='('&&c==')'||l!='{'&&c=='}'||l!='['&&c==']'){
        			return false;
        		}
        		else{
        			stack.pop();
        		}
        	}
        }
        return !stack.isEmpty()?false:true;
    }

}
