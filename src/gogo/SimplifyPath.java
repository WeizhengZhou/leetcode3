package gogo;

import java.util.Stack;

public class SimplifyPath {
	public static void main(String[] args) {
		SimplifyPath s = new SimplifyPath();
		System.out.println(s.simplifyPath("/./"));
	}
	public String simplifyPath(String path) {
        if (path==null ||path.length()==0) return "";
        Stack<String> s = new Stack<> ();
        int start = 0;
        while (start<path.length() && path.charAt(start)=='/') start++;
        int i = start;
        while (i<path.length()) {
        	while (i<path.length() && path.charAt(i) != '/') {
    			i++;
    		}
        	String sub = path.substring(start,i);System.out.println(sub);
        	if (sub.equals("..")) {
        		if (!s.isEmpty()) {
        			s.pop();
        		}
        	} else{
        		s.push(sub);
        	}
        	while (i<path.length() && path.charAt(i) == '/') {
    			i++;
    		}
        	start =i;
        }
        if (s.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
        	sb.append('/'+s.remove(0));
        }
        return sb.toString();
    }
}
