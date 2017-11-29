package gogo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII {
    public static void main(String[] args) {
    	WordLadderII w = new WordLadderII();
    	List<String> list = new LinkedList<> ();
    	list.add("hot");
    	list.add("dot");
    	list.add("dog");
    	list.add("lot");
    	list.add("log");
    	list.add("cog");
    	w.findLadders("hit","cog",list);
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    	List<List<String>> list = new LinkedList<> ();
		if (
				beginWord==null || endWord == null || beginWord.length()==0 || endWord.length()==0 || 
				beginWord.length() != endWord.length()
			) return list;
		if (!wordList.contains(endWord)) return list;
		Set<String> set = new HashSet<> ();
		set.add(beginWord);
		List<String> cur = new LinkedList<> ();
		cur.add(beginWord);
		List<String> next = new LinkedList<> ();
		Map<String, List<String>> map = new HashMap<> ();
		Set<String> dict = new HashSet<String> ();
		 for (String word:wordList) {
            dict.add(word);
        } 
		int count = 1;
		while (!cur.contains(endWord) && !cur.isEmpty()) {
			for(String s:cur) {
				char[] chars=s.toCharArray();
				for (int i=0;i<s.length();i++) {
					char c = chars[i];
					for (char rep='a';rep<='z';rep++) {
						if (rep==c) continue;
						chars[i] = rep;
						String sb = new String(chars);
						List<String> from= map.get(sb)==null? new LinkedList<String> () : map.get(sb);
						if ((set.contains(sb)||sb.equals(endWord)) && next.contains(sb)) {
							from.add(s);
							map.put(sb, from);
						}
						if ((dict.contains(sb) || sb.equals(endWord)) && !set.contains(sb) ) {						
							from.add(s);
		                    next.add(sb);
		                    map.put(sb,from);  
		                    set.add(sb);
						} 
					}
		            chars[i] = c;
				}
			}
			cur=new LinkedList<String> (next);
			next.clear();
			count++;
		}
		if (!cur.contains(endWord)) return list;
		helper(endWord,beginWord,count, map, new LinkedList<String> (), list);
		return list;
    }
    private void helper(String cur, String start,int count, Map<String, List<String>> map, List<String> buffer, List<List<String>> list) {
    	System.out.println("------cur="+cur);
    	if (cur.equals(start)) {
    		buffer.add(0, cur);
    		if (buffer.size()==count) {
    			list.add(new LinkedList<> (buffer));
    		}	
    		buffer.remove(0);
    		return;
    	}
    	if (!map.containsKey(cur)) {System.out.println("return");
			return;
		}
    	buffer.add(0,cur); 
    	List<String> from = map.get(cur);
    	for(String s: from) { System.out.println("s="+s);
    	}
    	for(String s: from) { System.out.println("====s="+s);
    		helper(s,start,count,map,buffer,list);
    	}
    	buffer.remove(0);
    }
}
