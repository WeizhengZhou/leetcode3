package gogo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConcatWords {
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new LinkedList<> ();
        if (s==null || s.length()==0 || words==null || words.length ==0 || words[0]==null || words[0].length()==0) return list;
        int len = words[0].length() * words.length;
        for(int i=0;i<=s.length()-len;i++){
        	if (match(s.substring(i, i+len), words)) {
        		list.add(i);
        	}
        }
        return list;
    }
	
	private boolean match(String s, String[] words) {
		Map<String, Integer> map = new HashMap<> ();
		for (int i =0; i<words.length; i++) {
			String word = words[i];
			if (!map.containsKey(word)) {
				map.put(word, 1);
			} else {
				map.put(word, map.get(word) + 1);
			}
		}
		int unitLen = words[0].length();
		int i = 0;
		while (i<s.length()) {
			String sub = s.substring(i, i+unitLen);
			if (!map.containsKey(sub)) return false;
			int count = map.get(sub);
			if (count == 1) {
				map.remove(sub);
			} else {
				map.put(sub, count -1);
			}
			i = i+unitLen;
		}
		return map.isEmpty();
	}
}
