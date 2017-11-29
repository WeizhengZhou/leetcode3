package gogo;

import java.util.Stack;

public class ValidParen {
	public boolean isValid(String s) {
        if(s==null ||s.length() == 0) return false;
        Stack<Character> stack= new Stack<>();
        for (int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if (c=='(' || c=='[' || c=='{') stack.push(c);
        	else {
        		if (stack.isEmpty()) return false;
        		char pre = stack.pop();
        		if ((pre == '(' && c!= ')') || (pre == '[' && c!= ']') || (pre == '{' && c!= '}')) {
        			return false;
        		}
        	}
        }
        return stack.isEmpty();
    }
}
