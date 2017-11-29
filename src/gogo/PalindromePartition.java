package gogo;

import java.util.LinkedList;
import java.util.List;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
    	List<List<String>> list = new LinkedList<> ();
    	if (s==null || s.length() ==0) return list;
    	boolean[][] isP = new boolean[s.length()][s.length()];
    	isP[0][0]=true;
    	for (int i=1;i<s.length();i++){
    		isP[i][i]=true;
    		isP[i-1][i] = s.charAt(i-1)==s.charAt(i);
    	}
    	for(int d=2;d<s.length();d++){
    		for(int i=0;i<s.length()-d;i++) {
    			isP[i][i+d] = isP[i+1][i+d-1] && s.charAt(i)==s.charAt(i+d);
    		}
    	}
    	helper(0,new LinkedList<String>(), s,isP,list);
    	return list;
    }
    
    private void helper(int index, List<String> buffer, String s, boolean[][] isP, List<List<String>> list) {
    	if (index>=s.length()){
    		list.add(new LinkedList<> (buffer));
    		return;
    	}
    	for(int i=index;i<s.length();i++){
    		if (isP[index][i]) {
    			buffer.add(s.substring(index,i+1));
    			helper(i+1,buffer,s,isP,list);
    			buffer.remove(buffer.size()-1);
    		}
    	}
    }
}
