package gogo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadder {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    	List<List<String>> list = new LinkedList<> ();
    	if (beginWord==null || endWord == null || beginWord.length()==0 || endWord.length()==0 || beginWord.length() != endWord.length()) return list;
    	Map<String, List<String>> map = new HashMap<> ();
    	List<String> cur = new LinkedList<> ();
    	cur.add(beginWord);
    	List<String> next = new LinkedList<> ();
    	while (!map.containsKey(endWord) && !cur.isEmpty()) {
    		for(String s:cur) {
    			char[] chars=s.toCharArray();
    			for (int i=0;i<s.length();i++) {
    				char c = chars[i];
    				for (char rep='a';rep<='z';rep++) {
    					if (rep==c) continue;
    					chars[i] = rep;
    					String sb = chars.toString();
    					if (wordList.contains(sb)) {
    						wordList.remove(sb);
    						List<String> from= map.get(sb)==null? new LinkedList<String> () : map.get(sb);
    						from.add(s);
    					}
    				}
    			}
    			cur=new LinkedList<String> (next);
    			next.clear();
    		}
    	}
    	if (!map.containsKey(endWord)) return list;
    	return list;
    }
    
    public static void main(String[] args) {
    	WordLadder w = new WordLadder();
    	List<String> list = new LinkedList<> ();
    	list.add("hot");
    	list.add("dot");
    	list.add("dog");
    	list.add("lot");
    	list.add("log");
    	list.add("cog");
    	System.out.println(w.ladderLength("hit","cog",list));
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	//List<List<String>> list = new LinkedList<> ();
		if (beginWord==null || endWord == null || beginWord.length()==0 || endWord.length()==0 || beginWord.length() != endWord.length()) return 0;
		if (!wordList.contains(endWord)) return 0;
		Set<String> set = new HashSet<> ();
		set.add(beginWord);
		List<String> cur = new LinkedList<> ();
		cur.add(beginWord);
		List<String> next = new LinkedList<> ();
		int count = 1;
		Set<String> list = new HashSet<String> ();
		 for (String word:wordList) {
            list.add(word);
        }
		while (!cur.contains(endWord) && !cur.isEmpty()) {
			for(String s:cur) {
				char[] chars=s.toCharArray();
				for (int i=0;i<s.length();i++) {
					char c = chars[i];
					for (char rep='a';rep<='z';rep++) {
						if (rep==c) continue;
						chars[i] = rep;
						String sb = new String(chars);
						if (list.contains(sb) && !set.contains(sb)) {
							set.add(sb);
							//List<String> from= map.get(sb)==null? new LinkedList<String> () : map.get(sb);
							//from.add(s);
		                    next.add(sb);
		                    //map.put(sb,from);
		                    if (sb.equals(endWord)) return count+1;
						}              
					}
		            chars[i] = c;
				}
			}
			cur=new LinkedList<String> (next);
			next.clear();
			count++;
		}
		if (!cur.contains(endWord)) return 0;
		return count;
    }
}
