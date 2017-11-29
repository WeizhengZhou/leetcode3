package gogo;

import java.util.LinkedList;
import java.util.List;

public class DiffWaysAddParan {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new LinkedList<> ();
        if (input==null || input.length()==0) return list;
        int num=0;
        for (int i=0;i<input.length();i++) {
        	char c=input.charAt(i);
        	if (c>='0'&& c<='9') {
        		num=num*10+c-'0';
        	} else if (c=='+' || c=='-' || c=='*') {
        		List<Integer> left=diffWaysToCompute(input.substring(0,i));
        		List<Integer> right=diffWaysToCompute(input.substring(i+1));
        		for(Integer a:left) {
        			for(Integer b:right) {
        				if (c=='+') {
        					list.add(a+b);
        				} else if (c=='-') {
        					list.add(a-b);
        				} else if (c=='*') {
        					list.add(a*b);
        				}
        			}
        		}
        	}
        }
        if (list.isEmpty()) {
        	list.add(num);
        }
        return list;
    }
}
