package gogo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new LinkedList<> ();
        if (s==null || s.length()==0) return list;
        Set<String> set=new HashSet<>(wordDict);
        Map<Integer, List<String>> map = new HashMap<> ();
        return helper(0,new StringBuilder(), s, set, map);
        
    }
    // not optimal, not passing OJ
    private List<String> helper(int index, StringBuilder sb, String s, Set<String> wordDict, Map<Integer, List<String>> map) {
    	if (map.containsKey(index)) return map.get(index);
    	List<String> list = new LinkedList<> ();
    	if (index>=s.length()) return list;
    	for (int i=index+1;i<=s.length();i++) {
    		String sub = s.substring(index,i);
    		if (wordDict.contains(sub)) {
    			if (index>0) {
    				sb.append(' ');
    			}
    			sb.append(sub);
    			helper(i,sb,s,wordDict,map);
    			sb.delete(sb.length()-sub.length(), sb.length());
    			if (index>0) {
    				sb.deleteCharAt(sb.length()-1);
    			}
    		}
    	}
    	return list;
    }
}
