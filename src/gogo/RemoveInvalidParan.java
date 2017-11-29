package gogo;

import java.util.LinkedList;
import java.util.List;
// ()())()
public class RemoveInvalidParan {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new LinkedList<> ();
        if (s==null || s.length()==0) return list;
        helper(0,0,s,list,'(',')');
        return list;
    }
    private void helper(int index, int jStart, String s, List<String> list, char keep, char remove) {
    	int left=0;
    	for (int i=index;i<s.length();i++) {
    		char c=s.charAt(i);
    		if(c==keep) left++;
    		if(c==remove) left--;
    		if(left>=0) continue;
    		for(int j=jStart;j<s.length();j++) {
    			char jChar=s.charAt(j);
    			if (jChar==remove && (j==jStart || s.charAt(j-1)!=remove)) {
    				helper(i,j,s.substring(0,j) + s.substring(j+1,s.length()),list,keep,remove);
    			}
    		}
    		return;
    	}
    	String reverse = new StringBuilder(s).reverse().toString();
    	if (remove==')') {
    		helper(0,0,reverse,list,')','(');
    	} else {
    		list.add(reverse);
    	}
    }
}
