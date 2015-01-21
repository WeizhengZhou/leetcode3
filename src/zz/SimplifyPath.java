package zz;

import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String simplifyPath(String path) {
		if(path==null || path.length()==0){
			return "/";
		}
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
			if(sub.equals(".")){
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
		while(!stack.isEmpty()){
			sb.insert(0, "/"+stack.pop());
		}
        if(sb.length()==0){
        	sb.insert(0,"/");
        }
		return sb.toString();
	}

}
