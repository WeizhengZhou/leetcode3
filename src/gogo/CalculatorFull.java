package gogo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CalculatorFull {
	public static void main(String[] args) {
		CalculatorFull cal=new CalculatorFull();
		List<String> list=new LinkedList<> (Arrays.asList("asd","sd"));
		System.out.println(cal.calculate("(1+3*2/2)*100-20/(4+1)"));
	}
	public int calculate(String s) {
		if (s==null || s.length()==0) return 0;
		Stack<Integer> stack = new Stack<> ();
		Stack<Character> ops = new Stack<> ();
		int i=0;
		Integer[] A=new Integer[] {1,2,3,1};
		Arrays.sort(A, (a,b)->b-a);
		while(i<s.length()) {
			char c=s.charAt(i);
			if (c>='0' && c<='9') {
				int start=i;
				while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9') i++;
				int cur=Integer.parseInt(s.substring(start,i));
				if (!ops.isEmpty() && (ops.peek()=='*' || ops.peek()=='/')) {
					int pre=stack.pop();
					char op=ops.pop();
					int r=op=='*' ? pre*cur : pre/cur;
					stack.push(r);
				} else {
					stack.push(cur);
				}
			} else if (c=='+' || c=='-' || c=='(' || c=='*' || c=='/') {
				ops.push(c);
				i++;
			} else if (c==')') {
				int r=0;
				while(!ops.isEmpty() && ops.peek()!='(') {
					int pre=stack.pop();
					char sign=ops.pop();
					r+=sign=='+'? pre : -pre;
				}
				r+=stack.pop();
				
				ops.pop();
				while(!ops.isEmpty() && (ops.peek()=='*'|| ops.peek()=='/')) {
					int pre=stack.pop();
					char op=ops.pop();
					r=op=='*'?pre*r:pre/r;
				}
				stack.push(r);			
				i++;
			} else {
				i++;
			}
		}
		int r=0;
		while(!stack.isEmpty()) {
			char sign=ops.isEmpty() ? '+' : ops.pop(); System.out.println(sign);
			int pre=stack.pop(); System.out.println(pre);
			r+=sign=='+' ? pre:-pre;
		}
		return r;
	}
}
