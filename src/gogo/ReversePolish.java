package gogo;

import java.util.Stack;

public class ReversePolish {
    public int evalRPN(String[] tokens) {
        if (tokens==null || tokens.length==0) {
        	return 0;
        }
        Stack<Integer> s = new Stack<> ();
        
        for (int i=0;i<tokens.length;i++) {
        	String cur = tokens[i];
        	if (cur.equals("+") || cur.equals("-")||cur.equals("*")||cur.equals("/")) {
        		int b = s.pop();
        		int a = s.pop();
        		int r = 0;
        		if (cur.equals("+")) r = a+b;
        		if (cur.equals("-")) r= a-b;
        		if (cur.equals("*")) r=a*b;
        		if (cur.equals("/")) r=a/b;
        		s.push(r);
        	} else {
        		int v = Integer.parseInt(cur);
        		s.push(v);
        	}
        }
        return s.pop();
    }
}
