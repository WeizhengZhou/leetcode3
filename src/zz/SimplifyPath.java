//zz reviewed
package zz;

import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "/./././../a/";
		System.out.println(new SimplifyPath().simplifyPath(s));
	}
	public String simplifyPath(String path) {
		if(path==null || path.length()==0){
			return "/";
		}
		//zz check if(s.charAt(0) == '/')
		Stack<String> stack=new Stack<String>();
		int i=0;
		while(i<path.length()){
			while(i<path.length() && path.charAt(i)=='/'){
				i++;
			}
			int start=i;
			if(i>=path.length()){
				break;
			}
			while( i<path.length() && path.charAt(i)!='/'){
				i++;
			}
			int end=i;
			String sub=path.substring(start,end);
			System.out.println(i+",  substring = " + sub+", nextToken = " + path.charAt(i));
			if(sub.equals(".")){//zz why i++?
				i++;
			}
			else if(sub.equals("..")){
				if(!stack.isEmpty()){
					stack.pop();
				}
			}
			else{
				stack.push(sub);
			}
		}
		StringBuilder sb=new StringBuilder();
		while(!stack.isEmpty()){//zz stringbuilder.insert(0) maybe inefficient
								//zz stringbuilder.inset(0) is O(n^2), see StringBuidlerTester class in this package
			sb.insert(0, "/"+stack.pop());
		}
        if(sb.length()==0){
        	sb.insert(0,"/");
        }
		return sb.toString();
	}

}
