package gogo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
    	List<List<Integer>> list=new LinkedList<> ();
    	if (words==null || words.length<2) return list;
    	Map<String, Integer> map=new HashMap<> ();
    	for(int i=0;i<words.length;i++){
    		map.put(words[i], i);
    	}
    	for(int i=0;i<words.length;i++) {
    		for(int j=0;j<words[i].length();j++) {
    			String s1=words[i].substring(0,j);
    			String s2=words[i].substring(j);
    			if (isPalin(s1)) {
    				StringBuilder sb=new StringBuilder(s2);
    				String reverse=sb.reverse().toString();
    				if (map.containsKey(reverse) && map.get(reverse)!=i) {
    					List<Integer> l=new LinkedList<> ();
    					l.add(map.get(reverse));
    					l.add(i);
    					list.add(l);
    				}
    			}
    			if (isPalin(s2)) {
    				StringBuilder sb=new StringBuilder(s1);
    				String reverse=sb.reverse().toString();
    				if (map.containsKey(reverse) && map.get(reverse)!=i) {
    					List<Integer> l=new LinkedList<> ();					
    					l.add(i);
    					l.add(map.get(reverse));
    					list.add(l);
    				}
    			}
    		}
    	}
    	return list;
    }
    
    private boolean isPalin(String s) {
    	int l=0;
    	int r=s.length()-1;
    	while(l<r) {
    		if (s.charAt(l++) !=s.charAt(r--)) return false;
    	}
    	return true;
    }
}
