package gogo;

import java.util.Stack;

public class Calculator {
    public int calculate(String s) {
        if (s==null || s.length()==0) return 0;
		int result=0;
		int sign = 1;
		Stack<Integer> stack=new Stack<> ();
		int i=0;
		while(i<s.length()) {
			char c=s.charAt(i);
			if (c == '+') {
				sign=1;
				i++;
			} else if(c == '-') {
				sign=-1;
				i++;
			} else if (c>='0' && c<='9') {
				int sum=0;
				while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9') {
					sum=sum*10+s.charAt(i)-'0';
					i++;
				}
				result = result + sign*sum;
			} else if (c=='(') {
				stack.push(result);
		        stack.push(sign);
				result=0;
				sign=1;
				i++;
			} else if (c==')') {
				int preSign = stack.pop();
				int pre=stack.pop();
				result = pre + preSign*result;
		        
		        i++;
			} else {
				i++;
			}
		}
		return result;
    }
}
