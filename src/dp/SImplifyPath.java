package dp;

import java.util.Stack;

public class SImplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SImplifyPath s=new SImplifyPath();
		System.out.println("\""+"rafa".substring(1, 1)+"\"");
		System.out.println(s.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
	}
    public String simplifyPath(String path) {
        if(path==null||path.length()==0){
        	return "/";
        }
        Stack<String> stack=new Stack<String>();
        for(int i=0;i<path.length();i++){
        	while(i<path.length() && path.charAt(i)=='/'){
        		i++;
        	}
        	int l=i;
        	while(i<path.length() && path.charAt(i)!='/'){
        		i++;
        	}
        	int r=i;
        	String sub=path.substring(l, r);
        	System.out.println(sub);
        	if(sub.equals("..")){
        		if(!stack.isEmpty()){
        			stack.pop();
        		}
        	}
        	else if(sub.equals(".")){
        		continue;
        	}
        	else{
        		stack.push(sub);
        	}
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
        	System.out.println(stack.peek());
        	sb.insert(0, stack.pop());
        	sb.insert(0,"/");
        }
        System.out.println(sb);
        if(sb.length()!=0&&sb.charAt(sb.length()-1)=='/'){
        	sb.deleteCharAt(sb.length()-1);
        }
        if(sb.length()==0){
        	sb.insert(0,"/");
        }
        return sb.toString();
    }
}
