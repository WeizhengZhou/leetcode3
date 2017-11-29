package gogo;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	public static void main(String[] args) {
		WordPattern w=new WordPattern();
		System.out.println(w.wordPattern("abba",
				"dog cat cat dog"));
	}
    public boolean wordPattern(String pattern, String str) {
        if (pattern==null || pattern.length()==0 || str==null) return false;
        Map<Character, String> map = new HashMap<> ();
        Map<String, Character> map2=new HashMap<> ();
        int index=0;
        for(int i=0;i<pattern.length();i++) {System.out.println("i="+i);
        	char c=pattern.charAt(i);System.out.println("c="+c);
        	int start=index;System.out.println("start="+start);
        	if (index>=str.length()) return false;
        	while(index<str.length() && str.charAt(index)!=' ') {index++;}
        	String s=str.substring(start, index);
        	System.out.println("index="+index);
        	System.out.println("s="+s);
        	System.out.println("===");
        	index++;
        	if (s==null || s.length()==0) return false;
        	if (!map.containsKey(c)) {
        		map.put(c, s);
        	} else {System.out.println(map.get(c));
        		if (!map.get(c).equals(s)) return false;
        	}
        	if (!map2.containsKey(s)) {
        		map2.put(s, c);
        	} else { System.out.println(map2.get(s));
        		if (map2.get(s) !=c) return false;
        	}
        }
        return index>=str.length();
    }
}
