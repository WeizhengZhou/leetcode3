package gogo;

import java.util.Stack;

public class CalculatorII {
    public int calculate(String s) {
        if(s==null||s.length()==0) return 0;
        int result=0;
        Stack<Integer> stack=new Stack<> ();
        int i=0;
        Character pre=null;
        while(i<s.length()) {
        	char c=s.charAt(i);
        	if (c>='0' && c<='9') {
        		int sum=0;
        		while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9') {
        			sum=sum*10+s.charAt(i)-'0';
        			i++;
        		}
        		if (pre!=null) {
        			int preN=stack.pop();
        			sum = pre=='*' ? preN*sum : preN/sum;
        		}
        		pre=null;
        		stack.push(sum);
        	} else if (c=='+' || c=='-') {
        		stack.push(c=='+'?1:-1);
        		i++;
        	} else if (c=='*' || c=='/') {
        		pre=c;
        		i++;
        	} else {
        		i++;
        	}
         }
        int sign=1;
        while(!stack.isEmpty()) {
        	int num=stack.pop();
        	if (!stack.isEmpty()) {
        		sign=stack.pop();
        	} else {
        		sign=1;
        	}
        	result = result+sign*num;
       	    	
        }
        return result;
    }
}
