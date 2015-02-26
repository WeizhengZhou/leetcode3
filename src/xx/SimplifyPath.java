package xx;
import java.util.*;

public class SimplifyPath {
	public String simplifyPath(String path) {

		if(path==null || path.length()==0){
			return "/";
		}
		LinkedList<String> stack=new LinkedList<>();
		//String word=getNext();
		int i=0;
		while(i<path.length()){
			while(i<path.length() && path.charAt(i)=='/'){i++;}
			if(i==path.length()){break;}
			int start=i;
			while(i<path.length() && path.charAt(i)!='/'){i++;}
			String word=path.substring(start,i);
			if(word.equals(".")){
				continue;
			}
			else if(word.equals("..")){
				if(!stack.isEmpty()){stack.pop();}
			}
			else{
				stack.push(word);
			}
			//word=getNext();
		}
		StringBuilder res=new StringBuilder();
		while(!stack.isEmpty()){
			res.append("/");
			res.append(stack.pollLast());

		}
		return res.length()==0?"/":res.toString();

	}
}
