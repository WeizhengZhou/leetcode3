package zz;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreakII w=new WordBreakII();
		Set<String> dict=new HashSet<String>();
		dict.add("a");
		/*dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");*/
		System.out.println(w.wordBreak("a", dict).toString());
		

	}
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> res=new LinkedList<String>();
        if(s==null || s.length()==0 || dict==null || dict.size()==0){
        	return res;
        }
        boolean[] breakable=new boolean[s.length()+1];
        breakable[0]=true;
        for(int i=1;i<=s.length();i++){
        	for(int j=0;j<i;j++){
        		if(breakable[j] && dict.contains(s.substring(j,i))){
        			breakable[i]=true;
        			break;
        		}
        	}
        }
        System.out.println(Arrays.toString(breakable));
        helper(s.length()-1,s,dict,res,breakable, new StringBuilder());
        return res;
    }
    
    public void helper(int index, String s, Set<String> dict, List<String> res, boolean[] breakable, StringBuilder sb){
    	if(index<0){
    		//System.out.println(sb.toString());
    		res.add(sb.toString().trim());
    		return;
    	}
    	for(int i=0;i<=index;i++){
    		if (breakable[i] && dict.contains(s.substring(i, index+1))){
    			sb.insert(0," ");
    			sb.insert(0,s.substring(i, index+1));
    			//System.out.println(sb.toString());
    			helper(i-1,s,dict,res,breakable,sb);
    			sb.delete(0, index-i+2);
    		}
    	}
    }
}
