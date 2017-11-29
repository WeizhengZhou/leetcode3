package gogo;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s==null || t==null || s.length()!=t.length()) return false;
        Map<Character, Character> map1 = new HashMap<> ();
        Map<Character, Character> map2 = new HashMap<> ();
        for (int i=0;i<s.length();i++) {
        	char sChar = s.charAt(i);
        	char tChar = t.charAt(i); 
        	if (!map1.containsKey(sChar) && map2.containsKey(tChar) ||
        		map1.containsKey(sChar) && !map2.containsKey(tChar)) {
        		return false;
        	} else if (map1.containsKey(sChar) && map2.containsKey(tChar)) {
        		if (map1.get(sChar) != tChar || map2.get(tChar) != sChar) {
        			return false;
        		}
        	} else {
        		map1.put(sChar, tChar);
        		map2.put(tChar, sChar);
        	}
        	
        }
        return true;
    }
}
